package org.academiadecodigo.bootcamp.blackwhitegrid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 31/05/17.
 */
public class Player implements KeyboardHandler {

    private Position pos;
    private Field grid;
    private Direction direction;

    public Player(Position pos, Field field) {
        this.pos = pos;
        pos.setColor(Color.BLUE);
        pos.fill();
        grid = field;
        direction = Direction.STOPPED;
        setUpKeys();
    }

    public Position getPos() {
        return pos;
    }

    public void setGrid(Field grid) {
        this.grid = grid;
    }


    private void setUpKeys() {
        Keyboard k1 = new Keyboard(this);
        KeyboardEvent pressdown = new KeyboardEvent();
        KeyboardEvent pressup = new KeyboardEvent();
        KeyboardEvent pressleft = new KeyboardEvent();
        KeyboardEvent pressright = new KeyboardEvent();
        KeyboardEvent ztocolor = new KeyboardEvent();
        KeyboardEvent xtouncolor = new KeyboardEvent();
        KeyboardEvent wtosave = new KeyboardEvent();
        KeyboardEvent ptoload = new KeyboardEvent();

        pressdown.setKey(KeyboardEvent.KEY_DOWN);
        pressdown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressup.setKey(KeyboardEvent.KEY_UP);
        pressup.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressleft.setKey(KeyboardEvent.KEY_LEFT);
        pressleft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressright.setKey(KeyboardEvent.KEY_RIGHT);
        pressright.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        ztocolor.setKey(KeyboardEvent.KEY_Z);
        ztocolor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        xtouncolor.setKey(KeyboardEvent.KEY_X);
        xtouncolor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        wtosave.setKey(KeyboardEvent.KEY_W);
        wtosave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        ptoload.setKey(KeyboardEvent.KEY_P);
        ptoload.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k1.addEventListener(pressdown);
        k1.addEventListener(pressup);
        k1.addEventListener(pressleft);
        k1.addEventListener(pressright);
        k1.addEventListener(ztocolor);
        k1.addEventListener(xtouncolor);
        k1.addEventListener(wtosave);
        k1.addEventListener(ptoload);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                pos.moveInDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                pos.moveInDirection(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                pos.moveInDirection(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                pos.moveInDirection(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_Z:
                grid.colorCell(pos);
                break;
            case KeyboardEvent.KEY_X:
                grid.uncolorCell(pos);
                break;
            case KeyboardEvent.KEY_W:
                SaverLoader.write(grid.sendState(),"resources/savedstate.txt");
                break;
            case KeyboardEvent.KEY_P:
                grid.getState(SaverLoader.read("resources/savedstate.txt"));
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}
