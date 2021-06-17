package org.talend.camel.designer.migration;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.talend.commons.exception.PersistenceException;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;

public class RenameCamel2ToCamel3PackagesMigrationTask extends AbstractRouteItemComponentMigrationTask {

//	public static void main(String[] args) {
//		String test = "\"/t:process/t:arg0/text()\", String.class, new org.apache.camel.builder.xml.Namespaces(\"t\", \"http://www.talend.com\")";
//		System.out.println(renameClassNamesInsideExpressions(test));
//	}

	private String valueExpression = null;
	private String valueLanguage = null;

	private static Map<String, String> classesMap;
	static {
		classesMap = new HashMap<String, String>();
		classesMap.put("org.apache.camel.builder.ExpressionBuilder",
				"org.apache.camel.support.builder.ExpressionBuilder");
		classesMap.put("org.apache.camel.builder.PredicateBuilder",
				"org.apache.camel.support.builder.PredicateBuilder");
		classesMap.put("org.apache.camel.builder.xml.Namespaces", "org.apache.camel.support.builder.Namespaces");
		classesMap.put("org.apache.camel.builder.xml.ValueBuilder", "org.apache.camel.support.builder.ValueBuilder");
		classesMap.put("org.apache.camel.builder.impl.BreakpointSupport", "org.apache.camel.support.BreakpointSupport");
		classesMap.put("org.apache.camel.builder.impl.DefaultComponent", "org.apache.camel.support.DefaultComponent");
		classesMap.put("org.apache.camel.builder.impl.DefaultConsumer", "org.apache.camel.support.DefaultConsumer");
		classesMap.put("org.apache.camel.builder.impl.DefaultAsyncProducer",
				"org.apache.camel.support.DefaultAsyncProducer");
		classesMap.put("org.apache.camel.builder.impl.DefaultExchange", "org.apache.camel.support.DefaultExchange");
		classesMap.put("org.apache.camel.builder.impl.DefaultExchangeHolder",
				"org.apache.camel.support.DefaultExchangeHolder");
		classesMap.put("org.apache.camel.builder.impl.DefaultHeaderFilterStrategy",
				"org.apache.camel.support.DefaultHeaderFilterStrategy");
		classesMap.put("org.apache.camel.builder.impl.DefaultMessage", "org.apache.camel.support.DefaultMessage");
		classesMap.put("org.apache.camel.builder.impl.DefaultMessageHistory",
				"org.apache.camel.support.DefaultMessageHistory");
		classesMap.put("org.apache.camel.builder.impl.DefaultProducer", "org.apache.camel.support.DefaultProducer");
		classesMap.put("org.apache.camel.builder.impl.DefaultRoute", "org.apache.camel.support.DefaultRoute");
		classesMap.put("org.apache.camel.builder.impl.SimpleRegistry", "org.apache.camel.support.SimpleRegistry");
		classesMap.put("org.apache.camel.builder.impl.SimpleUuidGenerator",
				"org.apache.camel.support.SimpleUuidGenerator");
		classesMap.put("org.apache.camel.builder.impl.TypedProcessorFactory",
				"org.apache.camel.support.TypedProcessorFactory");

	}
	public static Map<String, String> articleMapOne;

	@Override
	public String getComponentNameRegex() {
		return "cAggregate|cIdempotentConsumer|cLoadBalancer|cMessageFilter|cMessageRouter|cRecipientList|cSetBody|cSetHeader|cSetProperty|cSplitter|cWireTap";
	}

	public Date getOrder() {
		GregorianCalendar gc = new GregorianCalendar(2021, 6, 14, 13, 0, 0);
		return gc.getTime();
	}

	@Override
	protected boolean execute(NodeType node) throws Exception {
		return correctClassNames(node);
	}

	private boolean correctClassNames(NodeType currentNode) throws PersistenceException {

		boolean save = false;

		ElementParameterType paramLanguages = UtilTool.findParameterType(currentNode, "LANGUAGES");
		ElementParameterType paramExpression = UtilTool.findParameterType(currentNode, "EXPRESSION");

		if (paramLanguages == null || paramExpression == null) {
			return false;
		}

		valueLanguage = paramLanguages.getValue();
		valueExpression = paramExpression.getValue();

		if (valueLanguage == null || valueExpression == null) {
			return false;
		}


		String renameClassNamesInsideExpressions = renamePackageNamesInsideExpressions(valueExpression);
		if (!valueExpression.equalsIgnoreCase(renameClassNamesInsideExpressions)) {
			valueExpression = renameClassNamesInsideExpressions;
			save = true;
		}

		if (save) {
			for (Object e : currentNode.getElementParameter()) {
				ElementParameterType p = (ElementParameterType) e;
				if ("EXPRESSION".equals(p.getName())) {
					p.setValue(valueExpression);
					break;
				}
			}
		}

		return save;

	}

	private static String renamePackageNamesInsideExpressions(String valueExpression) {
		for (Map.Entry<String, String> entry : classesMap.entrySet()) {
			valueExpression = valueExpression.replaceAll(entry.getKey(), entry.getValue());
		}
		return valueExpression;
	}
}
