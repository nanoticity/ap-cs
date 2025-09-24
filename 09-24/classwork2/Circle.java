import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;


public class Circle extends JPanel {


	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		Color colorYellow = new Color(255, 255, 0);
		g.setColor(colorYellow);
		g.fillOval(50,50,100,100);

		Color colorBrown = new Color(153, 76, 0);
		g.setColor(colorBrown);
		g.fillRect(375, 400, 50, 200);

		Color colorGreen = new Color(0, 255, 0);
		g.setColor(colorGreen);
		g.fillOval(300, 300, 200, 200);
	}
}
