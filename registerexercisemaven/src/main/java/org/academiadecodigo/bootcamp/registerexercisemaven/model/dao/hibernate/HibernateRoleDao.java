package org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.hibernate;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.Role;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.Hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 11/07/17.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao {

    public HibernateRoleDao(){
        super(Role.class);
    }

    @Override
    public Role findByID(Integer id) {
        try {
            Session session= HibernateSessionManager.getInstance().getSession();

            Role role = null;
            Query query = session.createQuery("from Role where id = :id");
            query.setInteger("id", id);
            role = (Role) query.uniqueResult();
            return role;
        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public Role findByType(String roletype) {
        try {
            Session session=HibernateSessionManager.getInstance().getSession();

            Role role = null;
            Query query = session.createQuery("from Role where userType = :usertype");
            query.setString("usertype", roletype);
            role = (Role) query.uniqueResult();
            return role;

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }


}
