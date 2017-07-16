package org.academiadecodigo.bootcamp.registerexercisemaven.service.role;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.Role;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.Service;

/**
 * Created by codecadet on 11/07/17.
 */
public interface RoleService extends Service{

    public void addRole(Role role);

    public Role findRoleByType(String roletype);
}
