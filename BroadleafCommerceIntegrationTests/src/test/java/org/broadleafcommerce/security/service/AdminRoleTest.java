/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.broadleafcommerce.security.service;

import javax.annotation.Resource;

import org.broadleafcommerce.security.domain.AdminRole;
import org.broadleafcommerce.security.service.dataprovider.AdminRoleDataProvider;
import org.broadleafcommerce.test.BaseTest;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

public class AdminRoleTest extends BaseTest {
    @Resource
    AdminSecurityService adminSecurityService;

    @Test(groups =  {"testAdminRoleSave"}, dataProvider = "setupAdminRole", dataProviderClass = AdminRoleDataProvider.class)
    @Rollback(true)
    public void testAdminRoleSave(AdminRole role) throws Exception {
        AdminRole newRole = adminSecurityService.saveAdminRole(role);

        AdminRole roleFromDB = adminSecurityService.readAdminRoleById(newRole.getId());

        assert(roleFromDB != null);
    }

}
