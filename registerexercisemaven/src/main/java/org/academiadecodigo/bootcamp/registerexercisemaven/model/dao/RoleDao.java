package org.academiadecodigo.bootcamp.registerexercisemaven.model.dao;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.Role;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;

/**
 * Created by codecadet on 11/07/17.
 */
public interface RoleDao extends Dao<Role> {

    public Role findByType(String roletype);
}
