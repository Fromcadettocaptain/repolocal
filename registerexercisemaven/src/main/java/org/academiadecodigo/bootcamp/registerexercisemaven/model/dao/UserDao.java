package org.academiadecodigo.bootcamp.registerexercisemaven.model.dao;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionException;

/**
 * Created by codecadet on 11/07/17.
 */
public interface UserDao extends Dao<User>{

    User findByUsername(String username);

    User findByEmail(String email);

    int count();

}
