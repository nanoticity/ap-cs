import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;
import java.util.Random;

public class Scenery extends JPanel {

    // Colors
    private Color bridge = new Color(192, 54, 44);
    private Color day = new Color(159, 188, 255);
    private Color night = new Color(0, 63, 92);
    private Color sun = new Color(255, 240, 0);
    private Color moon = new Color(255, 255, 220);
    private Color wheel = new Color(0, 0, 0);
    private Color blue = new Color(100, 125, 255);
    private Color clouds = new Color(224, 224, 224);
    private Color ocean = new Color(0, 123, 147);
    private Color mountain = new Color(45, 75, 45);


    private int carX = -100;
    private int carX2 = 500;
    private int carX3 = 300;

    // scene state set by the Runner and used during painting
    private boolean isDay = true;
    private boolean isCloudy = false;
    private boolean isRainy = false;

    private Random r = new Random();

    private java.util.List<Point> cloudPositions = new java.util.ArrayList<>();
    private java.util.List<Point> rainPositions = new java.util.ArrayList<>();

    public Scenery(boolean day, boolean cloudy, boolean rainy) {
        // Store the requested scene options and let paintComponent do the drawing.
        this.isDay = day;
        this.isCloudy = cloudy;
        this.isRainy = rainy;
        // Do NOT call getGraphics() or painting methods here; component is not yet displayable.
    }

    private void drawBridge(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; 

        // continue with bridge drawing
        g2.setColor(bridge);

        // Pillars
        g2.fillRect(150, 100, 25, 400);
        g2.fillRect(550, 100, 25, 400);

        // Bridge middle part
        // Suspension cable
        int arcX = 163, arcY = 65, arcW = 400, arcH = 200;
        g2.setStroke(new BasicStroke(15));
        g2.drawArc(arcX, arcY, arcW, arcH, 180, 180);

        // Road
        int deckY = 350;
        g2.fillRect(150, deckY, 413, 10);

        // Suspended pillars
        g2.setStroke(new BasicStroke(1));

        // Using the ellipse equation to calculate pillar heights and y
        double centerX = arcX + arcW / 2.0;
        double centerY = arcY + arcH / 2.0;
        double a = arcW / 2.0;
        double b = arcH / 2.0;

       for (int i = 175; i <= 550; i += 10) {
            double dx = i - centerX;
            if (Math.abs(dx) > a) continue;
            double dy = b * Math.sqrt(1.0 - (dx * dx) / (a * a)) * -1;
            int pillarTopY = (int) Math.round(centerY - dy);
            int pillarHeight = deckY - pillarTopY;
            if (pillarHeight < 0) pillarHeight = 0;
            g2.fillRect(i, pillarTopY, 2, pillarHeight);
        }

        // Bridge left part
        arcX = 163 - arcW; arcY = 65; arcW = 400; arcH = 200;
        g2.setStroke(new BasicStroke(15));
        g2.drawArc(arcX, arcY, arcW, arcH, 180, 180);

        // Road (position relative to arcX)
        deckY = 350;
        g2.fillRect(arcX + 150, deckY, 413, 10);

        // Suspended pillars for left arc
        g2.setStroke(new BasicStroke(1));
        centerX = arcX + arcW / 2.0;
        centerY = arcY + arcH / 2.0;
        a = arcW / 2.0;
        b = arcH / 2.0;
        
        for (int i = arcX + 175; i <= arcX + 550; i += 10) {
            double dx = i - centerX;
            if (Math.abs(dx) > a) continue;
            double dy = b * Math.sqrt(1.0 - (dx * dx) / (a * a)) * -1;
            int pillarTopY = (int) Math.round(centerY - dy);
            int pillarHeight = deckY - pillarTopY;
            if (pillarHeight < 0) pillarHeight = 0;
            g2.fillRect(i, pillarTopY, 2, pillarHeight);
        }

        // Bridge right part
        arcX = 163 + arcW; arcY = 65; arcW = 400; arcH = 200;
        g2.setStroke(new BasicStroke(15));
        g2.drawArc(arcX, arcY, arcW, arcH, 180, 180);

        // Road (position relative to arcX)
        deckY = 350;
        g2.fillRect(arcX, deckY, 413, 10);

        // Suspended pillars for right arc
        g2.setStroke(new BasicStroke(1));
        centerX = arcX + arcW / 2.0;
        centerY = arcY + arcH / 2.0;
        a = arcW / 2.0;
        b = arcH / 2.0;
        
        for (int i = arcX; i <= arcX + 550; i += 10) {
            double dx = i - centerX;
            if (Math.abs(dx) > a) continue;
            double dy = b * Math.sqrt(1.0 - (dx * dx) / (a * a)) * -1;
            int pillarTopY = (int) Math.round(centerY - dy);
            int pillarHeight = deckY - pillarTopY;
            if (pillarHeight < 0) pillarHeight = 0;
            g2.fillRect(i, pillarTopY, 2, pillarHeight);
        }

        int[] mx = { -50, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140 , -500};
        int[] my = { 200, 210, 240, 250, 250, 270, 280, 290, 310, 350, 360, 400, 420, 450, 470, 500, 200};
        g2.setColor(mountain);
        g2.fillPolygon(mx, my, mx.length);

        g.setColor(ocean);
        g.fillRect(0, 400, getWidth(), 200);

    }
    
    private void drawCar(int whichX, Color c, Graphics g) {
        g.setColor(c);
        if (whichX == 1) {
            g.fillOval(carX, 340, 30, 10); // Car body
            g.setColor(wheel);
            g.fillOval(carX + 5, 347, 5, 5); // Left wheel
            g.fillOval(carX + 20, 347, 5, 5); // Right wheel
        } else if (whichX == 2) {
            g.fillOval(carX2, 340, 30, 10); // Car body
            g.setColor(wheel);
            g.fillOval(carX2 + 5, 347, 5, 5); // Left wheel
            g.fillOval(carX2 + 20, 347, 5, 5); // Right wheel
        } else {
            g.fillOval(carX3, 340, 30, 10); // Car body
            g.setColor(wheel);
            g.fillOval(carX3 + 5, 347, 5, 5); // Left wheel
            g.fillOval(carX3 + 20, 347, 5, 5); // Right wheel
        }

    }

    private void paintBackground(Color color, Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    private void drawSunMoon(Color c, Graphics g) {
        g.setColor(c);
        g.fillOval(25, 25, 100, 100);
    }

    private void day(boolean cloudy, boolean rainy, Graphics g) {
        paintBackground(day, g);
        if (rainy) {
            cloudy(g);
            rainy(g);
        } else {
            if (cloudy) {
                cloudy(g);
            } else {
                drawSunMoon(sun, g);
            }
        }
       
        drawCar(1, blue, g);
        drawCar(2, moon, g);
        drawCar(3, sun, g);
        drawBridge(g);
    }

    private void night(boolean cloudy, boolean rainy, Graphics g) {
        paintBackground(night, g);
        if (rainy) {
            cloudy(g);
            rainy(g);
        } else {
            if (cloudy) {
                cloudy(g);
            } else {
                drawSunMoon(moon, g);
            }
        }
       
        drawCar(1, blue, g);
        drawCar(2, moon, g);
        drawCar(3, sun, g);
        drawBridge(g);
    }

    private void drawCloud(int x, int y, Graphics g) {
        g.setColor(clouds);
        g.fillOval(x + 0,  y + 10, 70, 40);
        g.fillOval(x + 30, y + 0,  70, 45);
        g.fillOval(x + 60, y + 10, 70, 40);
        g.fillOval(x + 20, y + 20, 70, 40);
        g.fillOval(x + 45, y + 25, 70, 40);
    }

    public void generateClouds() {
        cloudPositions.clear();
        int count = 10;
        for (int i = 0; i < count; i++) {
            int x = r.nextInt(800);
            int y = r.nextInt(250);
            Point p = new Point(x, y);
            cloudPositions.add(p);
        }
    }

    private void cloudy(Graphics g) {
        for (Point p : cloudPositions) {
            drawCloud(p.x, p.y, g);
        }
    }

    private void drawDrop(int x, int y, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int w = 5;
        int h = 20;

        int ovalH = 10; 
        g2.setColor(blue);
        g2.fillOval(x, y, w, ovalH);

        int[] xs = { x, x + w / 2, x + w };
        int[] ys = { y + ovalH / 2, y + h, y + ovalH / 2 };
        g2.fillPolygon(xs, ys, 3);

    }

    public void generateRain() {
        rainPositions.clear();
        int count = 200;
        for (int i = 0; i < count; i++) {
            int x = r.nextInt(800);
            int y = -r.nextInt(700);
            Point p = new Point(x, y);
            rainPositions.add(p);
        }
    }

    private void rainy(Graphics g) {
        for (Point p : rainPositions) {
            drawDrop(p.x, p.y, g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isDay) {
            day(isCloudy, isRainy, g);
        } else {
            night(isCloudy, isRainy, g);
        }
    }

    public void animate() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (carX < 900) {
                carX ++;
            } else {
                carX = -100;
            }

            if (carX2 < 900) {
                carX2 ++;
            } else {
                carX2 = -100;
            }

            if (carX3 < 900) {
                carX3 ++;
            } else {
                carX3 = -100;
            }
            
            for (Point p : rainPositions) {
                p.y += 5;
                if (p.y >= 650) {
                    p.y = -r.nextInt(500);
                }
            }

            repaint();
        }


    }

    
}
