package nl.bongers.sokoban.model;

import java.awt.*;

public abstract class Item {

    private int row;
    private int column;
    private Color color;

    public Item(final int row, final int column, final Color color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Color getColor() {
        return color;
    }

    public Item setRow(int row) {
        this.row = row;
        return this;
    }

    public Item setColumn(int column) {
        this.column = column;
        return this;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
