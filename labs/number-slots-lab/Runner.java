import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Slot Machine");
            Screen screen = new Screen();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(screen);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
