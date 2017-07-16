package org.academiadecodigo.bootcamp.registerexercisemaven.service.role;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.Role;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionException;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionManager;

/**
 * Created by codecadet on 11/07/17.
 */
public class RoleServiceImplementation implements RoleService {

    private RoleDao roleDao;
    private TransactionManager transactionManager;

    public RoleServiceImplementation(TransactionManager transactionManager, RoleDao roleDao){
        this.roleDao=roleDao;
        this.transactionManager=transactionManager;
    }

    public String getName() {
        return RoleService.class.getSimpleName();
    }

    @Override
    public void addRole(Role role) {
        try {
            transactionManager.beginTransaction();
            roleDao.save(role);

            transactionManager.commitTransaction();
        } catch (TransactionException e) {
            transactionManager.rollBackTransaction();
        }
    }

    @Override
    public Role findRoleByType(String roletype) {
        Role role=null;

        try {
            transactionManager.beginTransaction();

            role = roleDao.findByType(roletype);

            transactionManager.commitTransaction();
        } catch (TransactionException ex) {
            transactionManager.rollBackTransaction();
        }
        return role;
    }
}
