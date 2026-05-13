package nl.bongers.sokoban.model;

import java.awt.*;

public class Player extends Entity {

    private Direction direction = Direction.DOWN;

    public Player(int row, int column) {
        super(row, column, Color.ORANGE, "player_down");
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    @Override
    public String getImageName() {
        return switch (direction) {
            case UP -> "player_up";
            case RIGHT -> "player_right";
            case DOWN -> "player_down";
            case LEFT -> "player_left";
        };
    }

    @Override
    public String toString() {
        return "@";
    }
}
