import javax.swing.JFrame;

public class Runner {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tree");
        Scenery canvas = new Scenery();

        frame.add(canvas);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);



    }
}
