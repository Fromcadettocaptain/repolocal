package org.academiadecodigo.bootcamp.registerexercisemaven.persistence;

/**
 * Created by codecadet on 11/07/17.
 */
public class TransactionException extends RuntimeException{
    public TransactionException(Throwable cause) {
        super(cause);
    }
}
