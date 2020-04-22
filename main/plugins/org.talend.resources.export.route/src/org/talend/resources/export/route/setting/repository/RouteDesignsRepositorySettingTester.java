package org.talend.resources.export.route.setting.repository;

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.designer.maven.ui.setting.repository.tester.AbstractRepositoryNodeRepositorySettingTester;

public class RouteDesignsRepositorySettingTester extends AbstractRepositoryNodeRepositorySettingTester {

	@Override
    protected ERepositoryObjectType getType() {
        return ERepositoryObjectType.PROCESS_ROUTE_DESIGN;
    }
}