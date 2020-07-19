package nl.bongers.sokoban.model;

import java.awt.*;

public class Player extends Item {

    private Color color;

    public Player(int row, int column) {
        super(row, column);
        this.color = Color.ORANGE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }
}
