package org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.hibernate;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.Dao;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.Hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 11/07/17.
 */
public class HibernateDao<T> implements Dao<T> {

    private Class<T> clazz;

    public HibernateDao(Class<T> clazz){
        this.clazz=clazz;
    }

    @Override
    public void save(T data) {
            try {
                Session session= HibernateSessionManager.getInstance().getSession();

                session.save(data);

            } catch (HibernateException ex) {
                throw new TransactionException(ex);
            }
    }

    @Override
    public void update(T data) {
        try {
            Session session=HibernateSessionManager.getInstance().getSession();

            session.update(data);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public void delete(T data) {
        try {
            Session session=HibernateSessionManager.getInstance().getSession();

            session.delete(data);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public T findByID(Integer id) {
            try {
                Session session=HibernateSessionManager.getInstance().getSession();

                T data = null;
                Query query = session.createQuery("from " + clazz.getSimpleName() + " where id = :id");
                query.setInteger("id", id);
                data = (T) query.uniqueResult();
                return data;
            } catch (HibernateException ex) {
                throw new TransactionException(ex);
            }
    }
}
