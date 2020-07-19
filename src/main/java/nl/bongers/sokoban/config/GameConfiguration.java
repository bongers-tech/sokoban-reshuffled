package nl.bongers.sokoban.config;

import java.awt.*;

public final class GameConfiguration {

    private GameConfiguration() {
        // No-args
    }

    public static final int ROWS = 30;
    public static final int COLUMNS = 30;
    public static final int POINTS_PER_SQUARE = 30;

    public static final boolean DRAW_GRID = true;
    public static final Dimension PANEL_SIZE = new Dimension(ROWS * POINTS_PER_SQUARE, COLUMNS * POINTS_PER_SQUARE);

}
