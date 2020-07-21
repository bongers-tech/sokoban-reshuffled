package nl.bongers.sokoban.util;

import nl.bongers.sokoban.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static nl.bongers.sokoban.config.GameConfiguration.COLUMNS;
import static nl.bongers.sokoban.config.GameConfiguration.ROWS;

public final class SceneUtil {

    private SceneUtil() {
        // No-args
    }

    public static Object[][] readScene(final Player player) {
        int currentRow = 0;
        final Object[][] scene = new Object[ROWS][COLUMNS];

        try {
            final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            final InputStream inputStream = classloader.getResourceAsStream("sokoban_1.txt");
            final InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            final BufferedReader reader = new BufferedReader(streamReader);
            for (String line; (line = reader.readLine()) != null; ) {
                final String[] chars = line.split("");
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i].equalsIgnoreCase("#")) {
                        scene[currentRow][i] = new Wall(currentRow, i);
                    } else if (chars[i].equalsIgnoreCase("@")) {
                        scene[currentRow][i] = player.setRow(currentRow).setColumn(i);
                    } else if (chars[i].equalsIgnoreCase("$")) {
                        scene[currentRow][i] = new Goal(currentRow, i);
                    } else if (chars[i].equalsIgnoreCase("&")) {
                        scene[currentRow][i] = new Box(currentRow, i);
                    } else {
                        scene[currentRow][i] = new Cell(currentRow, i);
                    }
                }
                currentRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scene;
    }
}
