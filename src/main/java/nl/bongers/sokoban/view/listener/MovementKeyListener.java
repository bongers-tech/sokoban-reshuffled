package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.model.*;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class MovementKeyListener extends DefaultKeyListener {

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        final Player player = getPlayer();
        final Object[][] scene = getScenePanel().getScene();

        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_KP_UP:
                if (scene[player.getRow() - 1][player.getColumn()] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow() - 1][player.getColumn()];
                    player.setRow(player.getRow() - 1);
                } else if (scene[player.getRow() - 1][player.getColumn()] instanceof Box && scene[player.getRow() - 2][player.getColumn()] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow() - 2][player.getColumn()];
                    scene[player.getRow() - 2][player.getColumn()] = scene[player.getRow() - 1][player.getColumn()];
                    player.setRow(player.getRow() - 1);
                } else if (scene[player.getRow() - 1][player.getColumn()] instanceof Box && scene[player.getRow() - 2][player.getColumn()] instanceof Goal) {
                    scene[player.getRow()][player.getColumn()] = new Cell(player.getRow(), player.getColumn());
                    scene[player.getRow() - 2][player.getColumn()] = new GoalBox(player.getRow() - 1, player.getColumn());
                    player.setRow(player.getRow() - 1);
                }
                break;
            case VK_D:
            case VK_KP_RIGHT:
                if (scene[player.getRow()][player.getColumn() + 1] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow()][player.getColumn() + 1];
                    player.setColumn(player.getColumn() + 1);
                } else if (scene[player.getRow()][player.getColumn() + 1] instanceof Box && scene[player.getRow()][player.getColumn() + 2] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow()][player.getColumn() + 2];
                    scene[player.getRow()][player.getColumn() + 2] = scene[player.getRow()][player.getColumn() + 1];
                    player.setColumn(player.getColumn() + 1);
                } else if (scene[player.getRow()][player.getColumn() + 1] instanceof Box && scene[player.getRow()][player.getColumn() + 2] instanceof Goal) {
                    scene[player.getRow()][player.getColumn()] = new Cell(player.getRow(), player.getColumn());
                    scene[player.getRow()][player.getColumn() + 2] = new GoalBox(player.getRow(), player.getColumn() + 1);
                    player.setColumn(player.getColumn() + 1);
                }
                break;
            case VK_S:
            case VK_KP_DOWN:
                if (scene[player.getRow() + 1][player.getColumn()] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow() + 1][player.getColumn()];
                    player.setRow(player.getRow() + 1);
                } else if (scene[player.getRow() + 1][player.getColumn()] instanceof Box && scene[player.getRow() + 2][player.getColumn()] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow() + 2][player.getColumn()];
                    scene[player.getRow() + 2][player.getColumn()] = scene[player.getRow() + 1][player.getColumn()];
                    player.setRow(player.getRow() + 1);
                } else if (scene[player.getRow() + 1][player.getColumn()] instanceof Box && scene[player.getRow() + 2][player.getColumn()] instanceof Goal) {
                    scene[player.getRow()][player.getColumn()] = new Cell(player.getRow(), player.getColumn());
                    scene[player.getRow() + 2][player.getColumn()] = new GoalBox(player.getRow() + 1, player.getColumn());
                    player.setRow(player.getRow() + 1);
                }
                break;
            case VK_A:
            case VK_KP_LEFT:
                if (scene[player.getRow()][player.getColumn() - 1] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow()][player.getColumn() - 1];
                    player.setColumn(player.getColumn() - 1);
                } else if (scene[player.getRow()][player.getColumn() - 1] instanceof Box && scene[player.getRow()][player.getColumn() - 2] instanceof Cell) {
                    scene[player.getRow()][player.getColumn()] = scene[player.getRow()][player.getColumn() - 2];
                    scene[player.getRow()][player.getColumn() - 2] = scene[player.getRow()][player.getColumn() - 1];
                    player.setColumn(player.getColumn() - 1);
                } else if (scene[player.getRow()][player.getColumn() - 1] instanceof Box && scene[player.getRow()][player.getColumn() - 2] instanceof Goal) {
                    scene[player.getRow()][player.getColumn()] = new Cell(player.getRow(), player.getColumn());
                    scene[player.getRow()][player.getColumn() - 2] = new GoalBox(player.getRow(), player.getColumn() - 1);
                    player.setColumn(player.getColumn() - 1);
                }
                break;
            default:
                break;
        }

        scene[player.getRow()][player.getColumn()] = player;
        getScenePanel().repaint();
    }
}
