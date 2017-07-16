package org.academiadecodigo.bootcamp.registerexercisemaven;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.Role;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.UserDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.hibernate.HibernateRoleDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.dao.hibernate.HibernateUserDao;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.Hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.Hibernate.HibernateTransactionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.Service;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.role.RoleService;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.role.RoleServiceImplementation;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.user.UserServiceImplementation;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.user.UserService;

public class Main extends Application {

    //ConnectionManager connectionManager = new ConnectionManager();

    @Override
    public void start(Stage primaryStage) throws Exception{

        // set the primary stage and instance navigation
        primaryStage.setTitle("Register Form");
        Navigation.getInstance().setStage(primaryStage);


        //instantiate services, add them to the service registry, and wire them to each view's controller
        UserDao userDao=new HibernateUserDao();
        TransactionManager transactionManager=new HibernateTransactionManager();
        UserService userService=new UserServiceImplementation(transactionManager,userDao);

        RoleDao roleDao=new HibernateRoleDao();
        RoleService roleService=new RoleServiceImplementation(transactionManager,roleDao);
        //roleService.addRole(new Role("Code cadet","On a journey to code heaven"));

        ServiceRegistry.getInstance().addService(userService);

        //load View.fxml
        Navigation.getInstance().loadScreen("View");

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        HibernateSessionManager.getInstance().close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
