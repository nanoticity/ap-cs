public class Game {
  private int[][] table;
  private int turn;

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
