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

class MoveEventListenerCellTest {

    private Scene scene;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        scene = SceneUtil.readScene("scene_empty");

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToCell() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(scene.getPlayer().getRow()).isEqualTo(2);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(2);
        assertThat(scene.getTile(0, 2)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(1, 2)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(2, 2)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(1);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(2);
        assertThat(scene.getTile(0, 2)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 2)).isInstanceOf(Player.class);
        assertThat(scene.getTile(2, 2)).isEqualTo(Tile.CELL);
    }

    @Test
    void testMovePlayerRightToCell() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(2);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(0, 2)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(2, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(2, 2)).isEqualTo(Tile.CELL);
    }

    @Test
    void testMovePlayerDownToCell() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(2);
        assertThat(scene.getTile(0, 2)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(3, 2)).isInstanceOf(Player.class);
        assertThat(scene.getTile(2, 2)).isEqualTo(Tile.CELL);
    }

    @Test
    void testMovePlayerLeftToCell() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(2);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 2)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(2, 1)).isInstanceOf(Player.class);
        assertThat(scene.getTile(2, 2)).isEqualTo(Tile.CELL);
    }
}
