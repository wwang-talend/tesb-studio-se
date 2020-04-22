package org.talend.resources.export.route.setting.repository;

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.designer.maven.ui.setting.repository.tester.AbstractRepositoryNodeRepositorySettingTester;
import org.talend.designer.maven.ui.setting.repository.tester.IRepositorySettingTester;
import org.talend.repository.model.IRepositoryNode;

public class RouteDesignsRepositorySettingTester extends AbstractRepositoryNodeRepositorySettingTester {

	@Override
    protected ERepositoryObjectType getType() {
        return ERepositoryObjectType.PROCESS_ROUTE_DESIGN;
    }
}