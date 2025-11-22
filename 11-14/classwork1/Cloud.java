import java.awt.Graphics;
import java.awt.Color;

public class Cloud {

    int x;
    int y;
    private int width = 80;

    public Cloud(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawMe(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x, y, width, 40);
        g.fillOval(x + 20, y - 15, width, 40);
        g.fillOval(x + 40, y, width, 35);
    }

    public void move() {
        x += 1;

        if (x > Screen.SCREEN_WIDTH) {
            x = -width - 20;
        }
    }
}