package nl.bongers.sokoban.model;

import java.awt.*;

public class Wall extends Item {

    public Wall(int row, int column) {
        super(row, column, Color.GRAY);
    }
}
