import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel {

    // Sun animation
    private int sunY = 300;
    private boolean day = true;

    // Animal 1: loops across screen
    private int animal1X = 0;

    // Animal 2: loops across screen
    private int animal2X = 200;

    // Animal 3: bounces
    private int animal3X = 400;
    private boolean moveRight = true;

    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawSky(g);
        drawGroundBase(g);
        drawGrassField(g);
        drawTreeField(g);
        drawVegetableField(g);
        drawAnimal1(g, animal1X, 500);
        drawAnimal2(g, animal2X, 530);
        drawAnimal3(g, animal3X, 560);

    }

    public void drawSky(Graphics g) {
        if (day) {
            g.setColor(new Color(135, 206, 235)); // Day sky
        } else {
            g.setColor(new Color(25, 25, 112)); // Night sky
        }
        g.fillRect(0, 0, getWidth(), 300);

        // Draw sun
        g.setColor(Color.YELLOW);
        g.fillOval(350, sunY, 100, 100);
    }


    public void drawGroundBase(Graphics g) {
        g.setColor(new Color(144, 238, 144));
        g.fillRect(0, 300, getWidth(), 300);
    }

    public void drawGrassField(Graphics g) {
        int spacing = 12;
        int startY = 300;
        int endY = getHeight();
        int endX = getWidth();

        for (int y = startY; y < endY; y += spacing) {
            for (int x = 0; x < endX; x += spacing) {
                drawGrass(g, x, y);
            }
        }
    }

    public void drawGrass(Graphics g, int x, int y) {
        g.setColor(new Color(0, 128, 0));
        g.drawLine(x, y, x, y - 12);
        g.drawLine(x - 2, y, x, y - 10);
        g.drawLine(x + 2, y, x, y - 10);
    }

    public void drawTreeField(Graphics g) {
        int startX = 100;
        int startY = 255;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 6; col++) {
                int x = col * 50 + startX;
                int y = row * 60 + startY;
                drawTree(g, x, y);
            }
        }
    }

    public void drawTree(Graphics g, int x, int y) {
        g.setColor(new Color(139, 69, 19));
        g.fillRect(x + 10, y + 30, 10, 20);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 30, 30);
    }

    public void drawVegetableField(Graphics g) {
        int startX = 500;
        int startY = 285;
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 5; col++) {
                int x = col * 30 + startX;
                int y = row * 40 + startY;
                drawPumpkin(g, x, y);
            }
        }
    }

    public void drawPumpkin(Graphics g, int x, int y) {
        g.setColor(new Color(255, 140, 0));
        g.fillOval(x, y, 20, 20);
        g.setColor(new Color(34, 139, 34));
        g.drawLine(x + 10, y, x + 10, y - 5);
    }
    public void drawAnimal1(Graphics g, int x, int y) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 40, 20); // body
        g.setColor(Color.BLACK);
        g.fillOval(x + 30, y - 10, 15, 15); // head
    }

    public void drawAnimal2(Graphics g, int x, int y) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 30, 20); // body
        g.setColor(Color.WHITE);
        g.fillOval(x + 10, y - 10, 15, 15); // head
    }

    public void drawAnimal3(Graphics g, int x, int y) {
        g.setColor(Color.PINK);
        g.fillOval(x, y, 35, 20); // body
        g.setColor(Color.RED);
        g.fillRect(x + 25, y - 10, 10, 10); // head
    }

    public void updateAnimation() {
        // Sun movement
        sunY -= 1;
        if (sunY < -300) {
            sunY = 300;
        }
        day = sunY > -100 && sunY <= 300;

        if (day) {
            // Animal 1: loops
            animal1X += 2;
            if (animal1X > getWidth()) {
                animal1X = -50;
            }

            // Animal 2: loops
            animal2X += 3;
            if (animal2X > getWidth()) {
                animal2X = -50;
            }

            // Animal 3: bounces
            if (moveRight) {
                animal3X += 4;
                if (animal3X > getWidth() - 50) {
                    moveRight = false;
                }
            } else {
                animal3X -= 4;
                if (animal3X < 0) {
                    moveRight = true;
                }
            }
        }
    }

}
