package nl.bongers.sokoban.util;

import nl.bongers.sokoban.model.Entity;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.model.Tile;

import static java.util.Objects.nonNull;

public final class CopyUtil {

    private CopyUtil() {
        // No-args
    }

    public static Scene copy(final Scene scene) {
        if (nonNull(scene)) {
            final Tile[][] copiedTiles = new Tile[scene.tiles().length][];
            for (int row = 0; row < scene.tiles().length; row++) {
                copiedTiles[row] = scene.tiles()[row].clone();
            }

            final Entity[][] copiedEntities = new Entity[scene.entities().length][];
            for (int row = 0; row < scene.entities().length; row++) {
                copiedEntities[row] = scene.entities()[row].clone();
            }

            return new Scene(copy(scene.player()), copiedTiles, copiedEntities);
        }
        return null;
    }

    public static Player copy(final Player player) {
        return new Player(player.getRow(), player.getColumn());
    }
}
