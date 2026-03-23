public class Game {
  private int[][] table;
  private int turn;

  /*
   * Instance Variable
   * - table : int[][]
   * - turn : int - use to identify who's turn it is
   * Constructor
   * + Game() - Sets table to be a 3x3 2d array of int. They should be filled with
   * zeros by default. Setup the turn variable. Setup the turn variable to 1. That
   * means if the turn is 1, player 1 goes first.
   * Methods
   * + printTable() : void - Print the 3x3 with each row having its own line. ( If
   * there's a 1 print an X, if there's a 2 print an O, and if there's a 0 print
   * an * as a place holder)
   * + insertXO(int,int) : void - Based upon the turn variable, takes in the
   * location of the 2d array, and replace that location with the number 1 for
   * player 1 or 2 for player 2 if the space at that location is a zero. The
   * player will lose that turn if the place they put in does not exist or is
   * already played. (There are no loops in this methods!)
   * + checkFull() : boolean - Return true if the all the zero spaces are taken,
   * and false otherwise.
   * + checkTicTacToe() : int - Return 1 if there’s a tic tac toe for player 1,
   * return 2 if there’s a tic tac toe for player 2, or return 0 if there is no
   * tic tac toe.
   * (Optional: You can do a 2D array of String or char to use X and O instead of
   * 1 and 2)
   * 
   * 
   */
  public Game() {
    table = new int[3][3];
    turn = 1;
  }

  public void printTable() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (table[i][j] == 1) {
          System.out.print("X ");
        } else if (table[i][j] == 2) {
          System.out.print("O ");
        } else {
          System.out.print("* ");
        }
      }
      System.out.println();
    }
  }

  public void insertXO(int x, int y) {
    if (x >= 0 && x < 3 && y >= 0 && y < 3 && table[x][y] == 0) {
      table[x][y] = turn;
    }
    turn = (turn == 1) ? 2 : 1;
  }

  public boolean checkFull() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (table[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public int checkTicTacToe() {
    // rows
    for (int i = 0; i < 3; i++) {
      if (table[i][0] != 0 && table[i][0] == table[i][1] && table[i][1] == table[i][2]) {
        return table[i][0];
      }
    }

    // cols
    for (int j = 0; j < 3; j++) {
      if (table[0][j] != 0 && table[0][j] == table[1][j] && table[1][j] == table[2][j]) {
        return table[0][j];
      }
    }

    // diag
    if (table[0][0] != 0 && table[0][0] == table[1][1] && table[1][1] == table[2][2]) {
      return table[0][0];
    }
    if (table[0][2] != 0 && table[0][2] == table[1][1] && table[1][1] == table[2][0]) {
      return table[0][2];
    }

    return 0;
  }

}
