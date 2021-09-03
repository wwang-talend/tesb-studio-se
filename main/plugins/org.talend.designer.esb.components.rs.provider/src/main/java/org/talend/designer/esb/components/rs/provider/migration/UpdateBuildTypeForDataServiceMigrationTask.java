package org.talend.designer.esb.components.rs.provider.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.runtime.process.TalendProcessArgumentConstant;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;

/**
 * Set 'OSGI' as build type for job with ESB components(APPINT-32684)
 */
public class UpdateBuildTypeForDataServiceMigrationTask extends AbstractJobMigrationTask {
	
    private static final List<String> ESB_COMPONENTS;
    static {
        final List<String> esbComponents = Arrays.asList("tRESTClient", "tRESTRequest", "tRESTResponse", "tESBConsumer",
                "tESBProviderFault", "tESBProviderRequest", "tESBProviderResponse", "tRouteInput", "tREST");
        ESB_COMPONENTS = Collections.unmodifiableList(esbComponents);
    }
    
	private static final ProxyRepositoryFactory FACTORY = ProxyRepositoryFactory.getInstance();

	public Date getOrder() {
		GregorianCalendar gc = new GregorianCalendar(2021, 8, 17, 00, 00, 00);
		return gc.getTime();
	}

	@Override
	public ExecutionResult execute(Item item) {
        boolean modified = false;
		try {
            modified = updateBuildType(item);
		} catch (Exception e) {
			ExceptionHandler.process(e);
			return ExecutionResult.FAILURE;
		}
        if (modified) {
            return ExecutionResult.SUCCESS_NO_ALERT;
        } else {
            return ExecutionResult.NOTHING_TO_DO;
        }
	}
	
    private boolean updateBuildType(Item item)
			throws PersistenceException {
		if (!(item instanceof ProcessItem)) {
            return false;
		}
		boolean needSave = false;
		for (Object o : ((ProcessItem) item).getProcess().getNode()) {
			if (!(o instanceof NodeType)) {
				continue;
			}
			NodeType currentNode = (NodeType) o;
			if (ESB_COMPONENTS.contains(currentNode.getComponentName())) {
	            needSave = true;
	            break;
			}
		}
		if (needSave) {
		    item.getProperty().getAdditionalProperties().put(TalendProcessArgumentConstant.ARG_BUILD_TYPE, "OSGI");
			FACTORY.save(item, true);
		}
        return needSave;
	}

}
