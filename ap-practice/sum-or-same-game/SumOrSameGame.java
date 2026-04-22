
public class SumOrSameGame {

    private int[][] puzzle;

    /**
     * Do not modify this constructor. It is used for testing purposes only.
     */
    public SumOrSameGame(int testCase) {
        if (testCase == 1) {
            puzzle = new int[][]{
                {0, 7, 9, 0},
                {7, 4, 1, 6},
                {8, 4, 1, 8}
            };
        } else if (testCase == 2) {
            puzzle = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {5, 4, 1, 2}
            };
        } else if (testCase == 3) {
            puzzle = new int[][]{
                {8, 1, 0, 5},
                {0, 4, 3, 6},
                {3, 4, 5, 8}
            };
        } else if (testCase == 4) {
            puzzle = new int[][]{
                {1, 7, 9},
                {2, 6, 5},
                {4, 4, 4}
            };
        }

    }

    /**
     * Creates a two-dimensional array and fills it with random integers, as
     * described in part (a) Precondition: numRows > 0; numCols > 0
     */
    public SumOrSameGame(int numRows, int numCols) {
        puzzle = new int[numRows][numCols];

        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[row].length; col++) {
                puzzle[row][col] = (int) (Math.random() * 9) + 1;
            }
        }
    }

    public void printPuzzle() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Identifies and clears an element of puzzle that can be paired with the
     * element at the given row and column, as described in part (b)
     * Preconditions: row and col are valid row and column indices in puzzle.
     * The element at the given row and column is between 1 and 9, inclusive.
     */
    public boolean clearPair(int row, int col) {
        int value = puzzle[row][col];

        for (int r = row; r < puzzle.length; r++) {
            for (int c = 0; c < puzzle[r].length; c++) {
                if (r == row && c == col) {
                    continue;
                }

                int otherValue = puzzle[r][c];
                if (otherValue == value || otherValue + value == 10) {
                    puzzle[row][col] = 0;
                    puzzle[r][c] = 0;
                    return true;
                }
            }
        }

        return false;
    }

    /* There may be instance variables, constructors,
    and methods that are not shown. */
}
