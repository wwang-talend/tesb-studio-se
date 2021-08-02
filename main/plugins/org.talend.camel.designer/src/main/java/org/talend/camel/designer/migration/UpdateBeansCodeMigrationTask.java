// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2021 Talend – www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.camel.designer.migration;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.talend.camel.core.model.camelProperties.BeanItem;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.migration.AbstractItemMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.repository.model.ProxyRepositoryFactory;

/**
 * Update core libraries version to default for beans, should run before login
 *
 */
public class UpdateBeansCodeMigrationTask extends AbstractItemMigrationTask {

    @Override
    public List<ERepositoryObjectType> getTypes() {
        List<ERepositoryObjectType> toReturn = new ArrayList<ERepositoryObjectType>();
        toReturn.add(ERepositoryObjectType.BEANS);
        return toReturn;
    }

    @Override
    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2019, 4, 20, 0, 0, 0);
        return gc.getTime();
    }

    @Override
    public ExecutionResult execute(Item item) {
        if (item instanceof BeanItem) {

            BeanItem beanItem = (BeanItem) item;

            String content = new String(beanItem.getContent().getInnerContent());

            String prePeplaceValue = "org.apache.camel.processor.aggregate.AggregationStrategy";
            String replaceValue = " org.apache.camel.AggregationStrategy ";
            String pattern = "(\\s*|\t|\r|\n)";

            StringBuffer computePattenBuffer = new StringBuffer();
            String[] computePattenArray = prePeplaceValue.split("\\.");

            for (int i = 0; i < computePattenArray.length; i++) {
                computePattenBuffer.append(pattern).append(computePattenArray[i]).append(pattern);
                if (i != computePattenArray.length - 1) {
                    computePattenBuffer.append(".");
                }
            }

            Pattern p = Pattern.compile(computePattenBuffer.toString());

            Matcher m = p.matcher(content);

            if (m.find()) {
                String result = content.replaceAll(computePattenBuffer.toString(), replaceValue);
                beanItem.getContent().setInnerContent(result.getBytes());
                try {
                    ProxyRepositoryFactory.getInstance().save(beanItem);
                    return ExecutionResult.SUCCESS_NO_ALERT;
                } catch (PersistenceException e) {
                    ExceptionHandler.process(e);
                    return ExecutionResult.FAILURE;
                }
            }
        }

        return ExecutionResult.NOTHING_TO_DO;
    }
}
