import javax.swing.*;

public class Runner {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Pixel Art Lab");
    Screen screen = new Screen();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(screen);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
