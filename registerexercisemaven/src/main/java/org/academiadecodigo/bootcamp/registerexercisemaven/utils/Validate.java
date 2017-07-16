package org.academiadecodigo.bootcamp.registerexercisemaven.utils;

/**
 * Created by codecadet on 23/06/17.
 */
public class Validate {

    public static boolean isEmail(String s){
        return s.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\." +
                "[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
    }
}
