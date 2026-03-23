import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    int turn = 1;
    Scanner scan = new Scanner(System.in);
    Game g = new Game();
    g.printTable();
    while (true) {
      System.out.println(
          "Player " + turn
              + ": Enter a coordinate point, coresponding to a point on the table (Eg. (0,0) for the top left corner): ");
      String point = scan.next();
      int x = Integer.parseInt(point.substring(1, 2));
      int y = Integer.parseInt(point.substring(3, 4));
      g.insertXO(y, x);
      g.printTable();

      if (g.checkTicTacToe() != 0) {
        System.out.println("Player " + g.checkTicTacToe() + " wins!");
        break;
      }

      if (g.checkFull()) {
        System.out.println("Tie!");
        break;
      }
      turn = (turn % 2) + 1;
    }
  }
}