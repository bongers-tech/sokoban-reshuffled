package nl.bongers.sokoban.view.scene;

import nl.bongers.sokoban.model.Goal;
import nl.bongers.sokoban.model.Item;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.util.SceneUtil;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.nonNull;
import static nl.bongers.sokoban.config.GameConfiguration.*;

public class ScenePanel extends JPanel {

    private final Player player = new Player(0, 0);
    private final Object[][] scene = SceneUtil.readScene(player);

    public ScenePanel() {
        setBackground(Color.WHITE);
        setSize(PANEL_SIZE);
        requestFocus();
    }

    public Object[][] getScene() {
        return scene;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        drawGrid(graphics);
        drawScene(graphics);
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
        for (int row = 0; row < scene.length; row++) {
            for (int column = 0; column < scene.length; column++) {
                final Item item = (Item) scene[row][column];
                if (nonNull(item) && nonNull(item.getColor())) {
                    graphics.setColor(item.getColor());
                    final Graphics2D graphics2D = (Graphics2D) graphics;
                    graphics2D.fillRect(column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, POINTS_PER_SQUARE, POINTS_PER_SQUARE);
                }
            }
        }
    }
}
