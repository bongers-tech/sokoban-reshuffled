package nl.bongers.sokoban.model;

import java.awt.*;

public class Done extends Item {

    public Done(int row, int column) {
        super(row, column, Color.GREEN, "done");
    }
}
