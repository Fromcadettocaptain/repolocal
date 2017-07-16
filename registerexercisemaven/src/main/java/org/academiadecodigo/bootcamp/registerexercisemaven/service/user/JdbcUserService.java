package org.academiadecodigo.bootcamp.registerexercisemaven.service.user;

import org.academiadecodigo.bootcamp.registerexercisemaven.EmailAlreadyInUse;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.Role;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.user.UserService;

import java.sql.*;

/**
 * Created by codecadet on 28/06/17.
 */
public class JdbcUserService implements UserService {

    Connection dbConnection;

    public JdbcUserService(Connection c) {
        dbConnection = c;
    }

    public JdbcUserService() {
    }

    public void setDbConnection(Connection c) {
        dbConnection = c;
    }

    @Override
    public int count() {
        int result = 0;

        try {

            // create a query
            String query = "SELECT COUNT(*) FROM users";
            //prepared statement without placeholders
            PreparedStatement statement = dbConnection.prepareStatement(query);

            // execute the query
            ResultSet resultSet = statement.executeQuery();

            // get the results
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

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
            // create a query
            String query = "SELECT * FROM users WHERE username=? and password=?";
            //prepared statement
            PreparedStatement statement = dbConnection.prepareStatement(query);
            //set placeholders
            statement.setString(1, username);
            statement.setString(2, pass);

            // execute the query
            ResultSet resultSet = statement.executeQuery();

            // get the results
            if (resultSet.next()) {
                authent = true;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authent;
    }

    public void addUser(User user) {
        try {
            // create a query
            String update = "INSERT INTO users (username, password, email, user_role) VALUES (?, ?, ?, ?)";
            //create prepared statement
            PreparedStatement statement = dbConnection.prepareStatement(update);
            //set values for placeholders
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4,1);

            // execute the query
            statement.executeUpdate();

            // ....
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            throw new EmailAlreadyInUse(ex.getMessage());
        }
    }

    ;

    @Override
    public User findByName(String usernametofind) {
        User user = null;
        try {
            // create a query
            String query = "SELECT * FROM users WHERE username=?";
            // create a prepared statement
            PreparedStatement statement = dbConnection.prepareStatement(query);
            //set values for the placeholder
            statement.setString(1, usernametofind);

            // execute the query
            ResultSet resultSet = statement.executeQuery();

            // user exists
            if (resultSet.next()) {


                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");

                user = new User(usernameValue, passwordValue, emailValue);

            }

            // ....
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User findByEmail(String emailtofind) {
        User user = null;
        try {
            // create a query
            String query = "SELECT * FROM users WHERE email=?";
            // create a prepared statement
            PreparedStatement statement = dbConnection.prepareStatement(query);
            //set values for the placeholder
            statement.setString(1, emailtofind);

            // execute the query
            ResultSet resultSet = statement.executeQuery();

            // user exists
            if (resultSet.next()) {


                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");

                user = new User(usernameValue, passwordValue, emailValue);

            }

            // ....
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    //public User findByEmail(String email);
    public String getName(){
        return UserService.class.getSimpleName();
    }
}
