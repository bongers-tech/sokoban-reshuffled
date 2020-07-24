package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.model.Box;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.util.SceneUtil;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveEventListenerBoxAndBoxTest {

    private Player player;
    private Object[][] grid;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        player = new Player(0, 0);
        grid = SceneUtil.readScene(player, "scene_box_box");

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToBoxAndBoxToBox() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[1][3]).isInstanceOf(Box.class);
        assertThat(grid[2][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[1][3]).isInstanceOf(Box.class);
        assertThat(grid[2][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerRightToBoxAndBoxToBox() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][5]).isInstanceOf(Box.class);
        assertThat(grid[3][4]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][5]).isInstanceOf(Box.class);
        assertThat(grid[3][4]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerDownToBoxAndBoxToBox() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[5][3]).isInstanceOf(Box.class);
        assertThat(grid[4][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[5][3]).isInstanceOf(Box.class);
        assertThat(grid[4][3]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerLeftToBoxAndBoxToBox() {
        final Scene scene = new Scene(player, grid);
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][1]).isInstanceOf(Box.class);
        assertThat(grid[3][2]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(player.getRow()).isEqualTo(3);
        assertThat(player.getColumn()).isEqualTo(3);
        assertThat(grid[3][1]).isInstanceOf(Box.class);
        assertThat(grid[3][2]).isInstanceOf(Box.class);
        assertThat(grid[3][3]).isInstanceOf(Player.class);
    }
}
