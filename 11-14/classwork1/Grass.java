import java.awt.Graphics;
import java.awt.Color;

public class Grass {

    int x;
    int y;

    public Grass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawMe(Graphics g) {
        g.setColor(new Color(0, 100, 0));
        g.drawLine(x, y, x, y - 5);
        g.drawLine(x + 2, y, x + 1, y - 3);
    }
}