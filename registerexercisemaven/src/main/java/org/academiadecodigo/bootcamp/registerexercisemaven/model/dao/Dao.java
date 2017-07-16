package org.academiadecodigo.bootcamp.registerexercisemaven.model.dao;

import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionException;

/**
 * Created by codecadet on 11/07/17.
 */
public interface Dao<T> {

    void save(T data);

    void update(T data);

    void delete(T data);

    T findByID(Integer id);
}
