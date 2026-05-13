package nl.bongers.sokoban.view.scene;

import nl.bongers.sokoban.model.Entity;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.model.Tile;
import nl.bongers.sokoban.util.ImageUtil;
import nl.bongers.sokoban.util.SceneUtil;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.nonNull;
import static nl.bongers.sokoban.config.GameConfiguration.*;

public class ScenePanel extends JPanel {

    private Scene scene;
    private int currentScene = 1;

    public ScenePanel() {
        this.scene = SceneUtil.readScene("scene_" + currentScene);

        setBackground(Color.WHITE);
        setPreferredSize(PANEL_SIZE);
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
        if (scene.isCleared()) {
            this.scene = SceneUtil.readScene("scene_" + ++currentScene);
        }
    }

    private void drawGrid(final Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                graphics.drawRect(column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, POINTS_PER_SQUARE, POINTS_PER_SQUARE);
            }
        }
    }

    private void drawScene(final Graphics graphics) {
        final Graphics2D graphics2D = (Graphics2D) graphics;
        drawTiles(graphics2D);
        drawEntities(graphics2D);
    }

    private void drawTiles(final Graphics2D graphics2D) {
        final Tile[][] tiles = scene.getTiles();

        for (int row = 0; row < tiles.length; row++) {
            for (int column = 0; column < tiles[row].length; column++) {
                final Tile tile = tiles[row][column];
                if (nonNull(tile)) {
                    if (nonNull(tile.getImageName())) {
                        final Image image = ImageUtil.getInstance().readImage(tile.getImageName());
                        graphics2D.drawImage(image, column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, null);
                    }
                }
            }
        }
    }

    private void drawEntities(final Graphics2D graphics2D) {
        final Entity[][] entities = scene.getEntities();

        for (int row = 0; row < entities.length; row++) {
            for (int column = 0; column < entities[row].length; column++) {
                final Entity entity = entities[row][column];
                if (nonNull(entity)) {
                    if (nonNull(entity.getImageName())) {
                        final Image image = ImageUtil.getInstance().readImage(entity.getImageName());
                        graphics2D.drawImage(image, column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, null);
                    } else if (nonNull(entity.getColor())) {
                        graphics2D.setColor(entity.getColor());
                        graphics2D.fillRect(column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, POINTS_PER_SQUARE, POINTS_PER_SQUARE);
                    }
                }
            }
        }
    }
}
