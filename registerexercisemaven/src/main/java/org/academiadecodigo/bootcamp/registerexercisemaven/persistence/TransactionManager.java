package org.academiadecodigo.bootcamp.registerexercisemaven.persistence;


/**
 * Created by codecadet on 11/07/17.
 */
public interface TransactionManager {

    public void commitTransaction();

    public void beginTransaction();

    public void rollBackTransaction();

}
