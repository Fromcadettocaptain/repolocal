package org.academiadecodigo.bootcamp.registerexercisemaven.model;

/**
 * Created by codecadet on 11/07/17.
 */
public class Role {

    private int id;
    private String userType;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role(String userType, String description) {
        this.userType = userType;
        this.description=description;
    }

    public Role(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String usertype) {
        this.userType = usertype;
    }
}
