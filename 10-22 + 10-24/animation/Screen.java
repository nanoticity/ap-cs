import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;




class Screen extends JPanel {

    private int cx = 100;
    private int cy = 0;
    private int dx = 700;
    private int ex = 200;
    private int ey = 200;
    private int fy = 500;
    private int vex = 2;
    private int vey = 1;
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    private void blueCircle(Graphics g, int x) {
        g.setColor(Color.BLUE);
        g.fillOval(x, 100, 100, 20);
    }

    private void yellowOval(Graphics g, int y) {
        g.setColor(Color.YELLOW);
        g.fillOval(600, y, 30, 30);
    }

    private void redSquare(Graphics g, int x) {
        g.setColor(Color.RED);
        g.fillRect(x, 150, 40, 40);
    }

    private void greenCircle(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 30, 30);
    }

    private void magentaOval(Graphics g, int y) {
        g.setColor(Color.MAGENTA);
        g.fillOval(300, y, 50, 20);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        blueCircle(g, cx);
        yellowOval(g, cy);
        redSquare(g, dx);
        greenCircle(g, ex, ey);
        magentaOval(g, fy);

    }

    public void animate() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (cx > this.getWidth()) cx = -100;
            cx++;

            cy += 2;
            if (cy > this.getHeight()) cy = -30;

            dx -= 3;
            if (dx < -50) dx = this.getWidth() + 50;

            ex += vex;
            ey += vey;
            if (ex < 0 || ex > this.getWidth() - 30) vex = -vex;
            if (ey < 0 || ey > this.getHeight() - 30) vey = -vey;

            fy -= 4;
            if (fy < -50) fy = this.getHeight() + 50;
            repaint();
        }


    }
}
