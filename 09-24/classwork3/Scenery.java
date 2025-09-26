import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;


public class Scenery extends JPanel {


	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Sky
		Color colorSkyBlue = new Color(153, 204, 255);
		g.setColor(colorSkyBlue);
		g.fillRect(0, 0, 800, 600);

		// Lake 
		Color colorWater = new Color(0, 102, 204);
		g.setColor(colorWater);
		g.fillRect(0, 475, 800, 200);

		// Ground
		Color colorGround = new Color(102, 204, 0);
		g.setColor(colorGround);
		g.fillRect(0, 500, 800, 100);

		// Tree 1
		Color colorBrown = new Color(153, 76, 0);
		g.setColor(colorBrown);
		g.fillRect(375, 350, 50, 200);

		Color colorGreen = new Color(0, 255, 0);
		g.setColor(colorGreen);
		g.fillOval(300, 250, 200, 200);

		// Tree 2
		g.setColor(colorBrown);
		g.fillRect(100, 350, 50, 200);

		g.setColor(colorGreen);
		g.fillOval(25, 250, 200, 200);

		// Tree 3
		g.setColor(colorBrown);
		g.fillRect(600, 350, 50, 200);

		g.setColor(colorGreen);
		g.fillOval(525, 250, 200, 200);

		// Cloud 1
		Color colorWhite = new Color(255, 255, 255);
		g.setColor(colorWhite);
		g.fillOval(500, 200, 100, 50);

		// Cloud 2
		g.setColor(colorWhite);
		g.fillOval(400, 100, 100, 50);

		// Sun
		Color colorYellow = new Color(255, 255, 0);
		g.setColor(colorYellow);
		g.fillOval(50,50,100,100);


	}
}
