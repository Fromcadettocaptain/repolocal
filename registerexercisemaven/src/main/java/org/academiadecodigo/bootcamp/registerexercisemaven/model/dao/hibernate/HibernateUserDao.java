package org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.hibernate;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.Role;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.UserDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.Hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.Hibernate.HibernateTransactionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionException;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.user.UserServiceImplementation;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by codecadet on 11/07/17.
 */
public class HibernateUserDao extends HibernateDao<User> implements UserDao {

    public HibernateUserDao(){
        super(User.class);
    }

    @Override
    public User findByUsername(String usernametofind) {
        try {
            Session session=HibernateSessionManager.getInstance().getSession();

            User user = null;
            Query query = session.createQuery("from User where username = :username");
            query.setString("username", usernametofind);
            user = (User) query.uniqueResult();
            return user;

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            Session session=HibernateSessionManager.getInstance().getSession();

            User user = null;
            Query query = session.createQuery("from User where email = :mail");
            query.setString("mail", email);
            user = (User) query.uniqueResult();
            return user;
        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public User findByID(Integer id) {
        try {
            Session session=HibernateSessionManager.getInstance().getSession();

            User user = null;
            Query query = session.createQuery("from User where id = :id");
            query.setInteger("id", id);
            user = (User) query.uniqueResult();
            return user;
        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public int count() {
        try {
            Session session=HibernateSessionManager.getInstance().getSession();

            Query query = session.createSQLQuery("SELECT * FROM users");
            List list=query.list();
            return list.size();

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
