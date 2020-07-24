package nl.bongers.sokoban.model;

import java.awt.*;

public class GoalBox extends Item {

    public GoalBox(int row, int column) {
        super(row, column, Color.GREEN, "goal_box");
    }
}
