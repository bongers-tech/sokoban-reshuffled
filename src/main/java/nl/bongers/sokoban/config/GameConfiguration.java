package nl.bongers.sokoban.config;

import java.awt.*;

public final class GameConfiguration {

    private GameConfiguration() {
        // Utility class
    }

    public static final int ROWS = 30;
    public static final int COLUMNS = 30;
    public static final int POINTS_PER_SQUARE = 30;

    public static final Dimension PANEL_SIZE = new Dimension(COLUMNS * POINTS_PER_SQUARE, ROWS * POINTS_PER_SQUARE);

}
