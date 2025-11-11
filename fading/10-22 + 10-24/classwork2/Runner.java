import javax.swing.JFrame;

public class Runner {
  
	public static void main(String[] args) {


		JFrame frame = new JFrame("Animation");
		Screen sc = new Screen();
		
		frame.add(sc);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// start animation on a background thread so the EDT is not blocked
		new Thread(() -> sc.animate()).start();
    }
}
