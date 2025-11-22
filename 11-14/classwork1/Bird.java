import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Bird {

    int x;
    int y;
    int groundY;
    private Random rand = new Random();

    public Bird(int x, int y, int groundY) {
        this.x = x;
        this.y = y;
        this.groundY = groundY;
    }

    public void drawMe(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(x - 10, y, x, y - 10);
        g.drawLine(x, y - 10, x + 10, y);
    }

    public void move() {
        x += rand.nextInt(5) - 2;
        y += rand.nextInt(5) - 2;

        if (x < -10) {
            x = Screen.SCREEN_WIDTH + 10;
        }
        if (x > Screen.SCREEN_WIDTH + 10) {
            x = -10;
        }

        if (y < 10) {
            y = 10;
        }
        if (y > groundY - 10) {
            y = groundY - 10;
        }
    }
}