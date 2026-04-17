
public class GridPath {

  // 2D Array of integers
  private int[][] grid;

  // For testing purposes
  public GridPath(int[][] grid) {
    this.grid = grid;
  }

  /**
   * Returns the Location representing a neighbor of the grid element at row and
   * col, as described in part (a) Preconditions: row is a valid row index and col
   * is a valid column index in grid. row and col do not specify the element in
   * the last row and last column of grid.
   */
  public Location getNextLoc(int row, int col) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (col == cols - 1) {
      return new Location(row + 1, col);
    }
    if (row == rows - 1) {
      return new Location(row, col + 1);
    }

    int right = grid[row][col + 1];
    int down = grid[row + 1][col];
    return (right < down) ? new Location(row, col + 1) : new Location(row + 1, col);
  }

  /**
   * Computes and returns the sum of all values on a path through grid, as
   * described in part (b) Preconditions: row is a valid row index and col is a
   * valid column index in grid. row and col do not specify the element in the
   * last row and last column of grid.
   */
  public int sumPath(int row, int col) {
    if (row == grid.length - 1 && col == grid[0].length - 1) {
      return grid[row][col];
    }
    return grid[row][col] + sumPath(getNextLoc(row, col).getRow(), getNextLoc(row, col).getCol());
  }

}
