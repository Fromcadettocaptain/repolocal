package org.academiadecodigo.bootcamp.blackwhitegrid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 31/05/17.
 */
public class Position {
    private int col;
    private int row;
    private Color color;
    private Field grid;
    private Rectangle rectangle;

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col  the column of the grid position
     * @param row  the row of the grid position
     * @param grid the grid in which the position will be displayed
     */
    public Position(int col, int row, Field grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.color = Color.RED;
        rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()),
                grid.getCellSize(), grid.getCellSize());
        show();
    }

    public Field getGrid() {
        return grid;
    }


    public void show() {
        rectangle.draw();
    }

    public void setColor(Color color2) {
        this.color = color2;
        rectangle.setColor(color2);
        show();
    }


    public void hide() {

        rectangle.delete();
    }

    public void fill() {
        rectangle.fill();
    }

    public boolean isFilled(){
        return rectangle.isFilled();
    }


    private void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }


    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }


    public Color getColor() {
        return color;
    }


    public void moveInDirection(Direction direction) {
        int initxpix = grid.columnToX(getCol());
        int initypix = grid.rowToY(getRow());
        switch (direction) {

            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
        int finalxpix = grid.columnToX(getCol());
        int finalypix = grid.rowToY(getRow());
        rectangle.translate(finalxpix - initxpix, finalypix - initypix);
        fill();
    }


    public boolean equals(Position pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }

    /**
     * Moves the position up
     */
    public void moveUp() {

        if (row > 0) {
            setPos(getCol(), getRow() - 1);
        }

    }

    /**
     * Moves the position down
     */
    public void moveDown() {

        if (row < grid.getRows() - 1) {
            setPos(getCol(), getRow() + 1);
        }
    }

    /**
     * Moves the position left
     */
    public void moveLeft() {

        if (col > 0) {
            setPos(getCol() - 1, getRow());
        }
    }

    /**
     * Moves the position right
     */
    public void moveRight() {
        if (col < grid.getCols() - 1) {
            setPos(getCol() + 1, getRow());
        }
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                ", getColor=" + color +
                '}';
    }
}
