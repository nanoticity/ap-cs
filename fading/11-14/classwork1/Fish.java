import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Fish {

    int x;
    int y;
    int lakeX, lakeY, lakeWidth, lakeHeight;
    private Random rand = new Random();

    public Fish(int x, int y, int lakeX, int lakeY, int lakeWidth, int lakeHeight) {
        this.x = x;
        this.y = y;
        this.lakeX = lakeX;
        this.lakeY = lakeY;
        this.lakeWidth = lakeWidth;
        this.lakeHeight = lakeHeight;
    }

    public void drawMe(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 20, 10);
        int[] xPoints = { x, x - 5, x - 5 };
        int[] yPoints = { y + 5, y, y + 10 };
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public void move() {
        x += rand.nextInt(3) - 1;
        y += rand.nextInt(3) - 1;

        if (x < lakeX + 5) {
            x = lakeX + 5;
        }
        if (x > lakeX + lakeWidth - 20) {
            x = lakeX + lakeWidth - 20;
        }

        if (y < lakeY + 5) {
            y = lakeY + 5;
        }
        if (y > lakeY + lakeHeight - 10) {
            y = lakeY + lakeHeight - 10;
        }
    }
}