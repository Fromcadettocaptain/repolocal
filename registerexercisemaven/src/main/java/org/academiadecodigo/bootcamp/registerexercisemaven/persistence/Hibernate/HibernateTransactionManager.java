package org.academiadecodigo.bootcamp.registerexercisemaven.persistence.Hibernate;

import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionManager;
import org.hibernate.HibernateException;

/**
 * Created by codecadet on 11/07/17.
 */
public class HibernateTransactionManager implements TransactionManager{

    @Override
    public void beginTransaction() {
        HibernateSessionManager.getInstance().getSession().beginTransaction();
    }

    @Override
    public void commitTransaction() {
        HibernateSessionManager.getInstance().getSession().getTransaction().commit();
    }

    @Override
    public void rollBackTransaction() {
        HibernateSessionManager.getInstance().getSession().getTransaction().rollback();
    }
}
