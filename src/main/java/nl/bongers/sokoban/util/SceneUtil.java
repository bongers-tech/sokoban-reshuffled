package nl.bongers.sokoban.util;

import nl.bongers.sokoban.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;
import static nl.bongers.sokoban.config.GameConfiguration.COLUMNS;
import static nl.bongers.sokoban.config.GameConfiguration.ROWS;

public final class SceneUtil {

    private SceneUtil() {
        // No-args
    }

    public static Scene readScene(final String sceneName) {
        return readScene(sceneName, ROWS, COLUMNS);
    }

    public static Scene readScene(final String sceneName, final int rows, final int columns) {
        int currentRow = 0;
        final Player player = new Player(0, 0);
        final Tile[][] tiles = new Tile[rows][columns];
        final Entity[][] entities = new Entity[rows][columns];
        final ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (final InputStream inputStream = classloader.getResourceAsStream(sceneName + ".txt");
             final InputStreamReader streamReader = new InputStreamReader(requireNonNull(inputStream), StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(streamReader)) {
            for (String line; (line = reader.readLine()) != null; ) {
                for (int i = 0; i < line.length(); i++) {
                    final char item = line.charAt(i);
                    switch (item) {
                        case '#' -> tiles[currentRow][i] = Tile.WALL;
                        case '$' -> tiles[currentRow][i] = Tile.GOAL;
                        case '0' -> tiles[currentRow][i] = Tile.ACTUAL;
                        case '1' -> tiles[currentRow][i] = Tile.DONE;
                        case '&' -> {
                            tiles[currentRow][i] = Tile.CELL;
                            entities[currentRow][i] = new Box(currentRow, i);
                        }
                        case '@' -> {
                            tiles[currentRow][i] = Tile.CELL;
                            player.setPosition(currentRow, i);
                            entities[currentRow][i] = player;
                        }
                        default -> tiles[currentRow][i] = Tile.CELL;
                    }
                }
                currentRow++;
            }
        } catch (final IOException e) {
            System.out.println("Error reading scene file: " + e.getMessage());
        }
        return new Scene(player, tiles, entities);
    }
}
