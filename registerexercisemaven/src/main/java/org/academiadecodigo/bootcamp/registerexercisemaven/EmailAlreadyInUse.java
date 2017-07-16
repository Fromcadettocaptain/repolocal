package org.academiadecodigo.bootcamp.registerexercisemaven;

/**
 * Created by codecadet on 28/06/17.
 */
public class EmailAlreadyInUse extends RuntimeException {

    public EmailAlreadyInUse(String message) {
        super(message);
    }

}
