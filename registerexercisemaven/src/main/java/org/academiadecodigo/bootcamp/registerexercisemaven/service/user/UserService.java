package org.academiadecodigo.bootcamp.registerexercisemaven.service.user;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.Service;

/**
 * Created by codecadet on 22/06/17.
 */
public interface UserService extends Service {

    public boolean authenticate(String username, String pass);

    public void addUser(User user);

    public User findByName(String name);

    public User findByEmail(String email);

    public int count();
}
