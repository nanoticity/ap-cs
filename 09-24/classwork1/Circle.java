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
		g.fillOval(400,200,100,100);
	}
}
