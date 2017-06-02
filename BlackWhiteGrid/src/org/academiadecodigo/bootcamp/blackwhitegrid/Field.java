package org.academiadecodigo.bootcamp.blackwhitegrid;

import javafx.geometry.Pos;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 31/05/17.
 */
public class Field {

    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private Rectangle rect1;
    private final int pixellength = 30;
    private Color gridColor;
    private Position[] posmatrix;


    public Field(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        posmatrix = new Position[cols * rows];
        for (int i = 0; i < posmatrix.length; i++) {
            posmatrix[i] = new Position(i % cols, ((int) i / cols), this);
        }
        rect1 = new Rectangle(PADDING, PADDING, cols * pixellength, rows * pixellength);
        gridColor = Color.WHITE;
    }


    public void init() {
        //display the grid
        rect1.draw();
    }

    public void colorCell(Position pos) {
        for (Position p : posmatrix) {
            if (p.equals(pos)) {
                p.fill();
            }
        }
    }

    public void uncolorCell(Position pos) {
        for (Position p : posmatrix) {
            if (p.equals(pos)) {
                p.show();
            }
        }
    }


    public String sendState() {
        String s = "";
        for (Position p : posmatrix) {
            if (p.isFilled()) {
                s = s.concat("1");
            } else {
                s = s.concat("0");
            }
        }
        return s;
    }

    public void getState(String s) {
        Character currchar;
        for (int i = 0; i < posmatrix.length; i++) {
            currchar = s.charAt(i);
            if (currchar.toString().equals("1")) {
                posmatrix[i].fill();
            } else if (currchar.toString().equals("0")) {
                posmatrix[i].show();
            }
        }
    }


    public int getCols() {
        return cols;
    }


    public int getRows() {
        return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return pixellength * cols;
    }

    /**
     * Obtains the height of the grid in pixels
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return pixellength * rows;
    }

    /**
     * Obtains the pixel width and height of a grid position
     */

    public int getCellSize() {
        return pixellength;
    }


    public Color getGridColor() {
        return gridColor;
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     *
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return PADDING + pixellength * row;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {

        return PADDING + pixellength * column;
    }
}
