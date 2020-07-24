package nl.bongers.sokoban.model;

import java.util.HashMap;
import java.util.Map;

public class Scene {

    private final Player player;
    private final Object[][] grid;
    private final Map<String, Goal> goals;

    public Scene(final Player player, final Object[][] grid) {
        this.player = player;
        this.grid = grid;
        this.goals = processGoals(grid);
    }

    public Player getPlayer() {
        return player;
    }

    public Object[][] getGrid() {
        return grid;
    }

    public Map<String, Goal> getGoals() {
        return goals;
    }

    private Map<String, Goal> processGoals(final Object[][] grid) {
        final Map<String, Goal> goalMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] instanceof Goal) {
                    final Goal goal = (Goal) grid[i][j];
                    goalMap.putIfAbsent(goal.getRow() + "" + goal.getColumn(), goal);
                }
            }
        }
        return goalMap;
    }
}
