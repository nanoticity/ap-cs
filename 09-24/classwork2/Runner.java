import javax.swing.JFrame;

public class Runner {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle");
        Circle circle = new Circle();

        frame.add(circle);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);



    }
}
