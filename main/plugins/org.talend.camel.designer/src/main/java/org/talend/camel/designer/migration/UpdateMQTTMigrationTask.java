package org.talend.camel.designer.migration;

import java.util.Date;
import java.util.GregorianCalendar;

import org.talend.commons.exception.PersistenceException;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;

public class UpdateMQTTMigrationTask extends AbstractRouteItemComponentMigrationTask {

    @Override
    public String getComponentNameRegex() {
        return "cMQConnectionFactory";
    }

    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2021, 6, 7, 13, 0, 0);
        return gc.getTime();
    }

	@Override
	protected boolean execute(NodeType node) throws Exception {
		return renameReConnDelay(node);
	}

	private boolean renameReConnDelay(NodeType currentNode) throws PersistenceException {
        boolean needSave = false;

        ElementParameterType param = UtilTool.findParameterType(currentNode, "MQTT_RECONNECT_DELAY");
        String value = param.getValue();

        for (Object e : currentNode.getElementParameter()) {
            ElementParameterType p = (ElementParameterType) e;
            if ("MQTT_MAX_RECONNECT_DELAY".equals(p.getName())) {
                p.setValue(value);
                needSave = true;
                break;
            }
        }

        return needSave;
	}

}
