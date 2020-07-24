package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.model.*;
import nl.bongers.sokoban.util.SceneUtil;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveEventListenerBoxAndGoalTest {

    private Player player;
    private Object[][] grid;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        player = new Player(0, 0);
        grid = SceneUtil.readScene(player, "scene_box_cell", 7, 7);

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToBoxAndBoxToGoal() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[0][3]).isInstanceOf(Wall.class);
        assertThat(grid[1][3]).isInstanceOf(Cell.class);
        assertThat(grid[2][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(2);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[0][3]).isInstanceOf(Wall.class);
        assertThat(grid[1][3]).isInstanceOf(Box.class);
        assertThat(grid[2][3]).isInstanceOf(Player.class);
        assertThat(grid[3][3]).isInstanceOf(Cell.class);
    }

    @Test
    void testMovePlayerRightToBoxAndBoxToGoal() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][6]).isInstanceOf(Wall.class);
        assertThat(grid[3][5]).isInstanceOf(Cell.class);
        assertThat(grid[3][4]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(4);
        assertThat(grid[3][6]).isInstanceOf(Wall.class);
        assertThat(grid[3][5]).isInstanceOf(Box.class);
        assertThat(grid[3][4]).isInstanceOf(Player.class);
        assertThat(grid[3][3]).isInstanceOf(Cell.class);
    }

    @Test
    void testMovePlayerDownToBoxAndBoxToGoal() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[6][3]).isInstanceOf(Wall.class);
        assertThat(grid[5][3]).isInstanceOf(Cell.class);
        assertThat(grid[4][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(4);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[6][3]).isInstanceOf(Wall.class);
        assertThat(grid[5][3]).isInstanceOf(Box.class);
        assertThat(grid[4][3]).isInstanceOf(Player.class);
        assertThat(grid[3][3]).isInstanceOf(Cell.class);
    }

    @Test
    void testMovePlayerLeftToBoxAndBoxToGoal() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][0]).isInstanceOf(Wall.class);
        assertThat(grid[3][1]).isInstanceOf(Cell.class);
        assertThat(grid[3][2]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(2);
        assertThat(grid[3][0]).isInstanceOf(Wall.class);
        assertThat(grid[3][1]).isInstanceOf(Box.class);
        assertThat(grid[3][2]).isInstanceOf(Player.class);
        assertThat(grid[3][3]).isInstanceOf(Cell.class);
    }
}
