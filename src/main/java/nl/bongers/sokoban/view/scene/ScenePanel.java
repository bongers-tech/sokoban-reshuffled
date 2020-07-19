package nl.bongers.sokoban.view.scene;

import nl.bongers.sokoban.model.Player;

import javax.swing.*;
import java.awt.*;

import static nl.bongers.sokoban.config.GameConfiguration.*;

public class ScenePanel extends JPanel {

    private final Player player = new Player(POINTS_PER_SQUARE, POINTS_PER_SQUARE);

    public ScenePanel() {
        setBackground(Color.WHITE);
        setSize(PANEL_SIZE);
        requestFocus();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        drawGrid(graphics);
        drawOuterWall(graphics);
        drawPlayer(graphics);
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

    private void drawOuterWall(final Graphics graphics) {
        graphics.setColor(Color.GRAY);
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (isOuterLayer(row, column)) {
                    final Graphics2D graphics2D = (Graphics2D) graphics;
                    graphics2D.fillRect(column * POINTS_PER_SQUARE, row * POINTS_PER_SQUARE, POINTS_PER_SQUARE, POINTS_PER_SQUARE);
                }
            }
        }
    }

    private void drawPlayer(final Graphics graphics) {
        graphics.setColor(player.getColor());
        final Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.fillRect(player.getColumn(), player.getRow(), POINTS_PER_SQUARE, POINTS_PER_SQUARE);
    }

    private boolean isOuterLayer(int row, int column) {
        return row == 0
                || column == 0
                || row == (ROWS - 1)
                || column == (COLUMNS - 1);
    }
}
