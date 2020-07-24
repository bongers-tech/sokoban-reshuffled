package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.model.Box;
import nl.bongers.sokoban.model.Cell;
import nl.bongers.sokoban.model.Goal;
import nl.bongers.sokoban.model.GoalBox;
import nl.bongers.sokoban.view.Sokoban;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.util.Objects.nonNull;
import static nl.bongers.sokoban.config.GameConfiguration.POINTS_PER_SQUARE;

public class DefaultMouseListener implements MouseListener {

    private Box selectedBox;

    @Override
    public void mouseClicked(MouseEvent e) {
        final Object[][] grid = Sokoban.getFrame().getGame().getScenePanel().getScene().getGrid();
        final Object item = grid[e.getY() / POINTS_PER_SQUARE][e.getX() / POINTS_PER_SQUARE];

        if (item instanceof Box) {
            selectedBox = (Box) item;
        } else if (nonNull(selectedBox) && item instanceof Cell) {
            final int row = ((Cell) item).getRow();
            final int column = ((Cell) item).getColumn();

            grid[selectedBox.getRow()][selectedBox.getColumn()] = new Cell(selectedBox.getRow(), selectedBox.getColumn());
            grid[row][column] = selectedBox;
            selectedBox.setRow(row);
            selectedBox.setColumn(column);
            selectedBox = null;

            Sokoban.getFrame().getGame().getScenePanel().getScene().getGoals().remove(row + "" + column);
            Sokoban.getFrame().getGame().getScenePanel().repaint();

        } else if (nonNull(selectedBox) && item instanceof Goal) {
            final int row = ((Goal) item).getRow();
            final int column = ((Goal) item).getColumn();

            grid[selectedBox.getRow()][selectedBox.getColumn()] = new Cell(selectedBox.getRow(), selectedBox.getColumn());
            grid[row][column] = new GoalBox(row, column);
            selectedBox = null;

            Sokoban.getFrame().getGame().getScenePanel().getScene().getGoals().remove(row + "" + column);
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
