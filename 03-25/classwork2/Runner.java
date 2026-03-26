import javax.swing.JFrame;

public class Runner {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Animals");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 300);
    
    Screen screen = new Screen();
    frame.add(screen);
    
    frame.setVisible(true);
  }
}
