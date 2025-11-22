import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Dog {

    int x;
    int y;
    int groundY;
    private Random rand = new Random();

    public Dog(int x, int y, int groundY) {
        this.x = x;
        this.y = y;
        this.groundY = groundY;
    }

    public void drawMe(Graphics g) {
        g.setColor(new Color(139, 69, 19));
        g.fillRect(x, y, 40, 20);
        g.fillRect(x - 10, y + 5, 10, 10);
        g.drawLine(x + 40, y + 10, x + 50, y + 5);
    }

    public void move() {
        x += rand.nextInt(5) - 2;
        y += rand.nextInt(3) - 1;

        if (x < 0) {
            x = 0;
        }
        if (x > Screen.SCREEN_WIDTH - 40) {
            x = Screen.SCREEN_WIDTH - 40;
        }

        if (y < groundY) {
            y = groundY;
        }
        if (y > Screen.SCREEN_HEIGHT - 20) {
            y = Screen.SCREEN_HEIGHT - 20;
        }
    }
}