package nl.bongers.sokoban.model;

import java.util.function.IntFunction;

public enum Move {

    NORTH(fr -> fr - 1, fc -> fc, sr -> sr - 2, sc -> sc),
    EAST(fr -> fr, fc -> fc + 1, sr -> sr, sc -> sc + 2),
    SOUTH(fr -> fr + 1, fc -> fc, sr -> sr + 2, sc -> sc),
    WEST(fr -> fr, fc -> fc - 1, sr -> sr, sc -> sc - 2);

    private final IntFunction<Integer> firstRow;
    private final IntFunction<Integer> firstColumn;
    private final IntFunction<Integer> secondRow;
    private final IntFunction<Integer> secondColumn;

    Move(final IntFunction<Integer> firstRow, final IntFunction<Integer> firstColumn, final IntFunction<Integer> secondRow, final IntFunction<Integer> secondColumn) {
        this.firstRow = firstRow;
        this.firstColumn = firstColumn;
        this.secondRow = secondRow;
        this.secondColumn = secondColumn;
    }

    public IntFunction<Integer> firstRow() {
        return firstRow;
    }

    public IntFunction<Integer> firstColumn() {
        return firstColumn;
    }

    public IntFunction<Integer> secondRow() {
        return secondRow;
    }

    public IntFunction<Integer> secondColumn() {
        return secondColumn;
    }
}
