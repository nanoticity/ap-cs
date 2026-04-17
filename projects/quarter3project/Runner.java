import javax.swing.*;

public class Runner {
  public static void main(String[] args) {
    JFrame frame = new JFrame("3 Card Poker");
    Table table = new Table();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(table);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
