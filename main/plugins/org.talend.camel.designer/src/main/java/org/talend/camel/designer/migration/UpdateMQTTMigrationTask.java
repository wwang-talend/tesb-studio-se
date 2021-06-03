package org.talend.camel.designer.migration;

import org.talend.core.model.migration.AbstractJobMigrationTask;

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

                                if (useProxy == null) {//$NON-NLS-1$
                                    return;
                                }

                                //todo: set the value to MQTT_MAX_RECONNECT_DELAY
                                
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
        GregorianCalendar gc = new GregorianCalendar(2021, 2, 22, 13, 0, 0);
        return gc.getTime();
    }

}
