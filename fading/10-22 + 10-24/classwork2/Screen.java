import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel {
    
    private int sunY;
    public Screen() {
        sunY = 500;
        
        setPreferredSize(new Dimension(800, 600));
    }

    private int sunX = 600;

    private int cloud1X = -150;
    private int cloud1Y = 60;
    private int cloud2X = 50;
    private int cloud2Y = 120;
    private int cloud3X = 300;
    private int cloud3Y = 40;
    private int cloudV = 1;

    private int animalX = -200;
    private int animalY = 380;
    private int animalV = 2;

    private int birdX = 900;
    private int birdY = 140;
    private int birdV = -3;

    private int balloonX = 200;
    private int balloonY = 700;
    private int balloonV = -1;

    private void drawCloud(Graphics g, int x, int y) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x, y, 60, 30);
        g.fillOval(x + 10, y - 10, 60, 30);
        g.fillOval(x + 20, y, 60, 30);
    }

    private void drawSun(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 80, 80);
        g.setColor(Color.black);
        g.drawOval(x, y, 80, 80);
    }

    private void drawAnimal(Graphics g, int x, int y) {
        g.setColor(new Color(150, 75, 0));
        g.fillRect(x, y, 60, 30);
        g.setColor(Color.black);
        g.drawRect(x, y, 60, 30);
        g.setColor(new Color(170, 85, 40));
        g.fillOval(x + 50, y - 15, 30, 30);
        g.setColor(Color.black);
        g.drawOval(x + 50, y - 15, 30, 30);
        g.setColor(Color.white);
        g.fillOval(x + 65, y - 5, 6, 6);
        g.setColor(Color.black);
        g.drawOval(x + 65, y - 5, 6, 6);
        g.setColor(new Color(120, 60, 0));
        g.fillRect(x + 5, y + 28, 6, 12);
        g.fillRect(x + 25, y + 28, 6, 12);
        g.setColor(new Color(160, 80, 40));
        g.fillOval(x - 10, y + 5, 20, 10);
    }

    private void drawBird(Graphics g, int x, int y) {
        g.setColor(Color.darkGray);
        g.fillOval(x, y, 20, 12);
        g.setColor(Color.gray);
        g.fillOval(x + 8, y - 8, 16, 12);
        g.setColor(Color.black);
        g.fillOval(x + 14, y + 2, 4, 4);
    }

    private void drawBalloon(Graphics g, int x, int y) {
        g.setColor(Color.magenta);
        g.fillOval(x, y, 30, 40);
        g.setColor(Color.black);
        g.drawLine(x + 15, y + 40, x + 15, y + 58);
        g.setColor(new Color(120, 60, 0));
        g.fillRect(x + 10, y + 58, 10, 8);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, w, h);

        int groundTop = h - 120;
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, groundTop, w, 120);

        g.setColor(new Color(101, 67, 33));
        int treeCount = 20;
        for (int i = 0; i < treeCount; i++) {
            int tx = 10 + i * (w / treeCount);
            int trunkW = 12;
            int trunkH = 24;
            int trunkX = tx;
            int trunkY = groundTop - trunkH;
            g.fillRect(trunkX, trunkY, trunkW, trunkH);
            g.setColor(new Color(34, 139, 34));
            g.fillOval(trunkX - 18, trunkY - 30, 48, 36);
            g.fillOval(trunkX - 8, trunkY - 44, 40, 40);
            g.fillOval(trunkX + 6, trunkY - 30, 36, 36);
            g.setColor(new Color(101, 67, 33));
        }

        g.setColor(new Color(0, 155, 0));
        int blades = 100;
        for (int i = 0; i < blades; i++) {
            int gx = (int) (i * (w / (double) blades));
            int gy = groundTop + 6 + (i % 3);
            g.fillRect(gx, gy, 2, 12);
        }

        drawCloud(g, cloud1X, cloud1Y);
        drawCloud(g, cloud2X, cloud2Y);
        drawCloud(g, cloud3X, cloud3Y);

        drawSunWithRays(g, sunX, sunY);

        drawAnimal(g, animalX, animalY);

        drawBird(g, birdX, birdY);

        drawBalloon(g, balloonX, balloonY);
    }

    private void drawSunWithRays(Graphics g, int x, int y) {
        g.setColor(new Color(255, 223, 0));
        for (int i = 0; i < 8; i++) {
            double angle = i * Math.PI / 4;
            int x1 = x + 40 + (int) (Math.cos(angle) * 60);
            int y1 = y + 40 + (int) (Math.sin(angle) * 60);
            g.drawLine(x + 40, y + 40, x1, y1);
        }
        
        drawSun(g, x, y);
    }

    public void animate() {
        while (true) {
            sunY += -1;
            if (sunY < -100) {
                sunY = getHeight();
            }
            
            cloud1X += cloudV;
            cloud2X += cloudV + 1;
            cloud3X += cloudV + 2;
            int w = getWidth();
            if (cloud1X > w + 100) cloud1X = -200;
            if (cloud2X > w + 100) cloud2X = -200;
            if (cloud3X > w + 100) cloud3X = -200;
            
            animalX += animalV;
            if (animalX > w + 50) animalX = -150;
            
            birdX += birdV;
            if (birdX < -60) birdX = w + 60;
            
            balloonY += balloonV;
            if (balloonY < -80) balloonY = getHeight() + 80;

            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            repaint();
        }
    }
}
