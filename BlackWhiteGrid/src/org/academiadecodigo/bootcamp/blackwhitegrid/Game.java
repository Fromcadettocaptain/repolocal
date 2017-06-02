package org.academiadecodigo.bootcamp.blackwhitegrid;

/**
 * Created by codecadet on 31/05/17.
 */
public class Game {

    /**
     * Graphical field
     */
    private Field grid;


    /**
     * Constructs a new grid
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     */

    public Game(int cols, int rows) {

        grid = new Field(cols, rows);

    }

    /**
     * INITIALIZES FIELD and player
     */
    public void init() {

        grid.init();

        Player player=new Player(new Position(0,0,grid),grid);
    }
}
