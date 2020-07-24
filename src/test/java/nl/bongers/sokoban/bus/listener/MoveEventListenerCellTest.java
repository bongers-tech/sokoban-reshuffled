package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.model.Cell;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.model.Wall;
import nl.bongers.sokoban.util.SceneUtil;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveEventListenerCellTest {

    private Player player;
    private Object[][] grid;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        player = new Player(0, 0);
        grid = SceneUtil.readScene(player, "scene_empty");

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToCell() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(player.getRow()).isEqualTo(2);
        assertThat(player.getColumn()).isEqualTo(2);
        assertThat(grid[0][2]).isInstanceOf(Wall.class);
        assertThat(grid[1][2]).isInstanceOf(Cell.class);
        assertThat(grid[2][2]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(1);
        assertThat(player.getColumn()).isEqualTo(2);
        assertThat(grid[0][2]).isInstanceOf(Wall.class);
        assertThat(grid[1][2]).isInstanceOf(Player.class);
        assertThat(grid[2][2]).isInstanceOf(Cell.class);
    }

    @Test
    void testMovePlayerRightToCell() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        eventListener.handle(event);
        assertThat(player.getRow()).isEqualTo(2);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[0][2]).isInstanceOf(Wall.class);
        assertThat(grid[2][3]).isInstanceOf(Player.class);
        assertThat(grid[2][2]).isInstanceOf(Cell.class);
    }

    @Test
    void testMovePlayerDownToCell() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        eventListener.handle(event);
        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(2);
        assertThat(grid[0][2]).isInstanceOf(Wall.class);
        assertThat(grid[3][2]).isInstanceOf(Player.class);
        assertThat(grid[2][2]).isInstanceOf(Cell.class);
    }

    @Test
    void testMovePlayerLeftToCell() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        eventListener.handle(event);
        assertThat(player.getRow()).isEqualTo(2);
        assertThat(player.getColumn()).isEqualTo(1);
        assertThat(grid[0][2]).isInstanceOf(Wall.class);
        assertThat(grid[2][1]).isInstanceOf(Player.class);
        assertThat(grid[2][2]).isInstanceOf(Cell.class);
    }
}
