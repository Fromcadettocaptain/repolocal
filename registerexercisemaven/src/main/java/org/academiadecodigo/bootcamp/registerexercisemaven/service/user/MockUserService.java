package org.academiadecodigo.bootcamp.registerexercisemaven.service.user;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;

import java.util.ArrayList;

/**
 * Created by codecadet on 22/06/17.
 */
public class MockUserService implements UserService {

    private ArrayList<User> userArrayList;

    public MockUserService() {
        userArrayList = new ArrayList<>();
    }

    public boolean authenticate(String username, String pass) {
        if (findByName(username) != null) {
            if (findByName(username).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        boolean mailexists = false;
        boolean nameexists=false;
        for (User u : userArrayList) {
            if (u.getEmail().equals(user.getEmail())) {
                mailexists = true;
            }
            if(u.getUsername().equals(user.getUsername())){
                nameexists=true;
            }
        }
        if (!mailexists && !nameexists) {
            userArrayList.add(user);
        }
    }

    public User findByName(String username) {
        for (User u : userArrayList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }




    public User findByEmail(String email){
        for(User u:userArrayList){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }


    public int count() {
        return userArrayList.size();
    }

    public String getName(){
        return UserService.class.getSimpleName();
    }
}
