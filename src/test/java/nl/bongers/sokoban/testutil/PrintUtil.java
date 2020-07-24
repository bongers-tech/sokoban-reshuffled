package nl.bongers.sokoban.testutil;

public final class PrintUtil {

    private PrintUtil() {
        // No-args
    }

    public static void printGrid(final String label, final Object[][] grid) {
        System.out.println("----- "+ label.toUpperCase() + " -----");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j < grid.length - 1) {
                    System.out.print(grid[i][j]);
                } else {
                    System.out.println(grid[i][j]);
                }
            }
        }
        System.out.println("");
    }
}
