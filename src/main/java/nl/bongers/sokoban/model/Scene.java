package nl.bongers.sokoban.model;

public class Scene {

    private final Player player;
    private final Tile[][] tiles;
    private final Entity[][] entities;

    public Scene(final Player player, final Tile[][] tiles, final Entity[][] entities) {
        this.player = player;
        this.tiles = tiles;
        this.entities = entities;
    }

    public Player getPlayer() {
        return player;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Entity[][] getEntities() {
        return entities;
    }

    public Tile getTile(final int row, final int col) {
        return tiles[row][col];
    }

    public Entity getEntity(final int row, final int col) {
        return entities[row][col];
    }

    public boolean isCleared() {
        for (int row = 0; row < tiles.length; row++) {
            for (int column = 0; column < tiles[row].length; column++) {
                if (tiles[row][column] == Tile.GOAL && !(entities[row][column] instanceof Box)) {
                    return false;
                }
            }
        }
        return true;
    }
}
