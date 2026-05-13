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

class MoveEventListenerGoalTest {

    private Scene scene;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        scene = SceneUtil.readScene("scene_goal");

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(0, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(1, 3)).isEqualTo(Tile.CELL);
        assertThat(scene.getTile(2, 3)).isEqualTo(Tile.GOAL);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(2);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(0, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(1, 3)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(2, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(1);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(0, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(2, 3)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);
    }

    @Test
    void testMovePlayerRightToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(4);
        assertThat(scene.getTile(3, 6)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(3, 5)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(3, 4)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(5);
        assertThat(scene.getTile(3, 6)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(3, 5)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 4)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);
    }

    @Test
    void testMovePlayerDownToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(4);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(6, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(5, 3)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(4, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(5);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(6, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(5, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(4, 3)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);
    }

    @Test
    void testMovePlayerLeftToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(2);
        assertThat(scene.getTile(3, 0)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(3, 1)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(3, 2)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(3, 0)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(3, 1)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 2)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);
    }
}
