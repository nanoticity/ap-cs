import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Farm Scenery");
        Screen sc = new Screen();
        javax.swing.Timer timer = new javax.swing.Timer(30, e -> {
            sc.updateAnimation();
            sc.repaint();
        });
        timer.start();

        frame.add(sc);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
