package org.academiadecodigo.bootcamp.registerexercisemaven.service.user;

import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.UserDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionException;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.user.UserService;

/**
 * Created by codecadet on 06/07/17.
 */
public class UserServiceImplementation implements UserService {

    private UserDao userDao;
    private TransactionManager transactionManager;

    @Override
    public int count() {
        int result = 0;

        try {
            transactionManager.beginTransaction();


            result=userDao.count();

            transactionManager.commitTransaction();
        } catch (TransactionException ex) {
            transactionManager.rollBackTransaction();
        }
        return result;
    }


    @Override
    public boolean authenticate(String username, String pass) {
        /*
        if (findByName(username) != null) {
            if (findByName(username).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
        */
        boolean authent = false;


        try {
            transactionManager.beginTransaction();

            User user=userDao.findByUsername(username);
            if(user != null){
                if(user.getPassword().equals(pass)){
                    authent=true;
                }
            }
            /*
            Query query = session.createQuery("from User where username = :username and password = :password");
            query.setString("username", username);
            query.setString("password", pass);
            User u = (User) query.uniqueResult();
            if(u!=null){
                authent=true;
            }
            */

            transactionManager.commitTransaction();
        } catch (TransactionException ex) {
            transactionManager.rollBackTransaction();
        }
        return authent;
    }

    @Override
    public void addUser(User user) {

        try {
            transactionManager.beginTransaction();
            userDao.save(user);

            transactionManager.commitTransaction();
        } catch (TransactionException e) {
            transactionManager.rollBackTransaction();
        }
    }


    @Override
    public User findByName(String usernametofind) {
        User user=null;

        try {
            transactionManager.beginTransaction();

            user = userDao.findByUsername(usernametofind);

            transactionManager.commitTransaction();
        } catch (TransactionException ex) {
            transactionManager.rollBackTransaction();
        }
        return user;
    }

    @Override
    public User findByEmail(String mailtofind) {
        User user = null;

        try {
            transactionManager.beginTransaction();
            user = userDao.findByEmail(mailtofind);

            transactionManager.commitTransaction();
        } catch (TransactionException ex) {
            transactionManager.rollBackTransaction();
        }
        return user;
    }

    //public User findByEmail(String email);
    public String getName() {
        return UserService.class.getSimpleName();
    }

    public UserServiceImplementation(TransactionManager transactionManager, UserDao userDao){
        this.userDao=userDao;
        this.transactionManager=transactionManager;
    }
}
