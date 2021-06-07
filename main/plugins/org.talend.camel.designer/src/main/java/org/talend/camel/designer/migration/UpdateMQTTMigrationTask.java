package org.talend.camel.designer.migration;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.model.components.ComponentUtilities;
import org.talend.core.model.components.ModifyComponentsAction;
import org.talend.core.model.components.conversions.IComponentConversion;
import org.talend.core.model.components.filters.IComponentFilter;
import org.talend.core.model.components.filters.NameComponentFilter;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;
import org.talend.designer.core.model.utils.emf.talendfile.ProcessType;

public class UpdateMQTTMigrationTask extends AbstractJobMigrationTask {

    @Override
    public ExecutionResult execute(Item item) {
        ProcessType processType = getProcessType(item);
        if (getProject().getLanguage() != ECodeLanguage.JAVA || processType == null) {
            return ExecutionResult.NOTHING_TO_DO;
        }

        String[] componentsName = new String[] { "cMQConnectionFactory" }; //$NON-NLS-1$
        for (String name : componentsName) {
            IComponentFilter filter = new NameComponentFilter(name);
            try {
                ModifyComponentsAction.searchAndModify(item, processType, filter, Arrays
                        .<IComponentConversion> asList(new IComponentConversion() {

                            public void transform(NodeType node) {
                                ElementParameterType reConnDelay = ComponentUtilities.getNodeProperty(node, "MQTT_RECONNECT_DELAY");

                                if (reConnDelay == null) {//$NON-NLS-1$
                                    return;
                                }

                                // migrate "MQTT_RECONNECT_DELAY" to "MQTT_MAX_RECONNECT_DELAY"
                                ElementParameterType maxReconnDelay =
                                        ComponentUtilities.getNodeProperty(node, "MQTT_MAX_RECONNECT_DELAY"); //$NON-NLS-1$
                                if (reConnDelay.getValue() != null) { //$NON-NLS-1$
                                    maxReconnDelay.setValue(reConnDelay.getValue()); //$NON-NLS-1$
                                }
                                
                            }
                        }));
            } catch (PersistenceException e) {
                ExceptionHandler.process(e);
                return ExecutionResult.FAILURE;
            }
        }

        return ExecutionResult.SUCCESS_WITH_ALERT;

    }

    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2021, 6, 7, 13, 0, 0);
        return gc.getTime();
    }

}
