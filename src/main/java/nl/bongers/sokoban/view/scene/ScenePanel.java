package nl.bongers.sokoban.view.scene;

import nl.bongers.sokoban.model.Item;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.util.SceneUtil;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.nonNull;
import static nl.bongers.sokoban.config.GameConfiguration.*;

public class ScenePanel extends JPanel {

    private Scene scene;
    private int currentScene = 1;

    public ScenePanel() {
        final Player player = new Player(0, 0);
        this.scene = new Scene(player, SceneUtil.readScene(player, "scene_" + currentScene));

        setBackground(Color.WHITE);
        setSize(PANEL_SIZE);
        requestFocus();
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        checkSceneCleared();
        drawScene(graphics);
        drawGrid(graphics);
    }

    private void checkSceneCleared() {
        if (scene.getGoals().isEmpty()) {
            this.scene = new Scene(scene.getPlayer(), SceneUtil.readScene(scene.getPlayer(), "scene_" + ++currentScene));
        }
    }

    private void drawGrid(final Graphics graphics) {
        if (DRAW_GRID) {
            graphics.setColor(Color.LIGHT_GRAY);
            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS; column++) {
                    graphics.drawRect(column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, POINTS_PER_SQUARE, POINTS_PER_SQUARE);
                }
            }
        }
    }

    private void drawScene(final Graphics graphics) {
        final Object[][] grid = scene.getGrid();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
                final Item item = (Item) grid[row][column];
                if (nonNull(item)) {
                    final Graphics2D graphics2D = (Graphics2D) graphics;
                    graphics2D.clearRect(column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, POINTS_PER_SQUARE, POINTS_PER_SQUARE);
                    if (nonNull(item.getImage())) {
                        graphics2D.drawImage(item.getImage(), item.getColumn() * POINTS_PER_SQUARE, item.getRow() * POINTS_PER_SQUARE, null);
                    } else if (nonNull(item.getColor())) {
                        graphics.setColor(item.getColor());
                        graphics2D.fillRect(column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, POINTS_PER_SQUARE, POINTS_PER_SQUARE);
                    }
                }
            }
        }
    }
}
