package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 23/05/17.
 */
public class Player extends Car implements KeyboardHandler {

    private final int SPEED=1;
    private GridDirection direction;
    private boolean movingornot;

    public Player(GridPosition pos) {
        super(pos, CarType.PLAYER);
        movingornot=false;
        setUpKeys();
    }

    private void setUpKeys() {
        Keyboard k1 = new Keyboard(this);
        KeyboardEvent pressdown=new KeyboardEvent();
        KeyboardEvent reldown=new KeyboardEvent();
        KeyboardEvent pressup=new KeyboardEvent();
        KeyboardEvent relup=new KeyboardEvent();
        KeyboardEvent pressleft=new KeyboardEvent();
        KeyboardEvent relleft=new KeyboardEvent();
        KeyboardEvent pressright=new KeyboardEvent();
        KeyboardEvent relright=new KeyboardEvent();
        pressdown.setKey(KeyboardEvent.KEY_DOWN);
        pressdown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        reldown.setKey(KeyboardEvent.KEY_DOWN);
        reldown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        pressup.setKey(KeyboardEvent.KEY_UP);
        pressup.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        relup.setKey(KeyboardEvent.KEY_UP);
        relup.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        pressleft.setKey(KeyboardEvent.KEY_LEFT);
        pressleft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        relleft.setKey(KeyboardEvent.KEY_LEFT);
        relleft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        pressright.setKey(KeyboardEvent.KEY_RIGHT);
        pressright.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        relright.setKey(KeyboardEvent.KEY_RIGHT);
        relright.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k1.addEventListener(pressdown);
        k1.addEventListener(reldown);
        k1.addEventListener(pressup);
        k1.addEventListener(relup);
        k1.addEventListener(pressleft);
        k1.addEventListener(relleft);
        k1.addEventListener(pressright);
        k1.addEventListener(relright);
    }

    @Override
    public void move() {
        if (movingornot==true) {
            accelerate(direction, SPEED);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_PRESSED){
                    direction=GridDirection.UP;
                    movingornot=true;
                } else {movingornot=false;}
                break;
            case KeyboardEvent.KEY_DOWN:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_PRESSED){
                    direction=GridDirection.DOWN;
                    movingornot=true;
                } else {movingornot=false;}
                break;
            case KeyboardEvent.KEY_LEFT:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_PRESSED){
                    direction=GridDirection.LEFT;
                    movingornot=true;
                } else {movingornot=false;}
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_PRESSED){
                    direction=GridDirection.RIGHT;
                    movingornot=true;
                } else {movingornot=false;}
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_RELEASED){
                movingornot=false;}
                break;
            case KeyboardEvent.KEY_DOWN:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_RELEASED){
                    movingornot=false;}
                break;
            case KeyboardEvent.KEY_LEFT:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_RELEASED){
                    movingornot=false;}
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (keyboardEvent.getKeyboardEventType()==KeyboardEventType.KEY_RELEASED){
                    movingornot=false;}
                break;
        }
    }
}
