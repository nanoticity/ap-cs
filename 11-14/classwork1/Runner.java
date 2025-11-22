import javax.swing.JFrame;

public class Runner {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Forest Scene");

        frame.setSize(Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Screen sc = new Screen();
        frame.add(sc);

        frame.setVisible(true);

        new Thread(() -> sc.animate()).start();
    }
}