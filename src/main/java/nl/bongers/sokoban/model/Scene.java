package nl.bongers.sokoban.model;

public record Scene(Player player, Tile[][] tiles, Entity[][] entities) {

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