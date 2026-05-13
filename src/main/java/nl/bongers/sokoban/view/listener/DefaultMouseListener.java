package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.model.Box;
import nl.bongers.sokoban.model.Entity;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.model.Tile;
import nl.bongers.sokoban.view.Sokoban;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.util.Objects.nonNull;
import static nl.bongers.sokoban.config.GameConfiguration.POINTS_PER_SQUARE;

public class DefaultMouseListener implements MouseListener {

    private Box selectedBox;

    @Override
    public void mouseClicked(MouseEvent e) {
        final Scene scene = Sokoban.getFrame().getGame().getScenePanel().getScene();
        final Tile[][] tiles = scene.getTiles();
        final Entity[][] entities = scene.getEntities();

        final int row = e.getY() / POINTS_PER_SQUARE;
        final int column = e.getX() / POINTS_PER_SQUARE;

        final Tile tile = tiles[row][column];
        final Entity entity = entities[row][column];

        if (entity instanceof Box) {
            selectedBox = (Box) entity;
        } else if (nonNull(selectedBox) && !Tile.WALL.equals(tile)) {
            entities[selectedBox.getRow()][selectedBox.getColumn()] = null;
            entities[row][column] = selectedBox;
            selectedBox.setPosition(row, column);
            selectedBox = null;

            Sokoban.getFrame().getGame().getScenePanel().repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }
}
