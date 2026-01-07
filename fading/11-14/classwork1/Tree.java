import java.awt.Graphics;
import java.awt.Color;

public class Tree {

    int x;
    int y;

    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawMe(Graphics g) {
        g.setColor(new Color(139, 69, 19));
        g.fillRect(x - 5, y - 40, 10, 40);

        g.setColor(new Color(0, 128, 0));
        g.fillOval(x - 25, y - 80, 50, 50);
    }
}