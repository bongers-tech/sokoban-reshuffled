package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.model.*;
import nl.bongers.sokoban.testutil.PrintUtil;
import nl.bongers.sokoban.util.SceneUtil;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveEventListenerBoxAndWallTest {

    private Player player;
    private Object[][] grid;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        player = new Player(0, 0);
        grid = SceneUtil.readScene(player, "scene_box_wall");

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToBoxAndBoxToWall() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[1][3]).isInstanceOf(Wall.class);
        assertThat(grid[2][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[1][3]).isInstanceOf(Wall.class);
        assertThat(grid[2][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerRightToBoxAndBoxToWall() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][5]).isInstanceOf(Wall.class);
        assertThat(grid[3][4]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][5]).isInstanceOf(Wall.class);
        assertThat(grid[3][4]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerDownToBoxAndBoxToWall() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[5][3]).isInstanceOf(Wall.class);
        assertThat(grid[4][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[5][3]).isInstanceOf(Wall.class);
        assertThat(grid[4][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerLeftToBoxAndBoxToWall() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][1]).isInstanceOf(Wall.class);
        assertThat(grid[3][2]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][1]).isInstanceOf(Wall.class);
        assertThat(grid[3][2]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }
}
