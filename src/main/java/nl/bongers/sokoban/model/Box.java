package nl.bongers.sokoban.model;

import java.awt.*;

public class Box extends Item {

    public Box(int row, int column) {
        super(row, column, new Color(183, 145, 106), null);
    }

    @Override
    public String toString() {
        return "&";
    }
}
