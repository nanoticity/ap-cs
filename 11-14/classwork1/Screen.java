import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Screen extends JPanel {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private int groundY = 400;
    
    private int lakeX = 500;
    private int lakeY = 450;
    private int lakeWidth = 200;
    private int lakeHeight = 100;

    private Tree[] myTrees;
    private Cloud[] myClouds;
    private Grass[] myGrass;
    private Dog myDog;
    private Bird[] myBirds;
    private Fish[] myFish;

    private Random rand = new Random();

    public Screen() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        myTrees = new Tree[100];
        for (int i = 0; i < myTrees.length; i++) {
            int randX = rand.nextInt(SCREEN_WIDTH);
            int randY = groundY + rand.nextInt(SCREEN_HEIGHT - groundY - 50);
            myTrees[i] = new Tree(randX, randY);
        }

        myClouds = new Cloud[20];
        for (int i = 0; i < myClouds.length; i++) {
            int randX = rand.nextInt(SCREEN_WIDTH);
            int randY = 50 + rand.nextInt(groundY - 200);
            myClouds[i] = new Cloud(randX, randY);
        }

        myGrass = new Grass[100];
        for (int i = 0; i < myGrass.length; i++) {
            int randX = rand.nextInt(SCREEN_WIDTH);
            int randY = groundY + rand.nextInt(SCREEN_HEIGHT - groundY);
            myGrass[i] = new Grass(randX, randY);
        }
        
        myDog = new Dog(150, 450, groundY);
        
        myBirds = new Bird[5];
        for (int i = 0; i < myBirds.length; i++) {
            int randX = rand.nextInt(SCREEN_WIDTH);
            int randY = 50 + rand.nextInt(groundY - 100);
            myBirds[i] = new Bird(randX, randY, groundY);
        }
        
        myFish = new Fish[4];
        for(int i = 0; i < myFish.length; i++) {
            int randX = lakeX + 10 + rand.nextInt(lakeWidth - 20);
            int randY = lakeY + 10 + rand.nextInt(lakeHeight - 20);
            myFish[i] = new Fish(randX, randY, lakeX, lakeY, lakeWidth, lakeHeight);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, SCREEN_WIDTH, groundY);

        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, groundY, SCREEN_WIDTH, SCREEN_HEIGHT - groundY);

        g.setColor(Color.BLUE);
        g.fillOval(lakeX, lakeY, lakeWidth, lakeHeight);
        
        for (int i = 0; i < myFish.length; i++) {
            myFish[i].drawMe(g);
        }

        g.setColor(new Color(160, 82, 45));
        g.fillRect(100, 280, 120, 120);

        g.setColor(Color.RED);
        int[] xPoints = { 90, 230, 160 };
        int[] yPoints = { 280, 280, 210 };
        g.fillPolygon(new Polygon(xPoints, yPoints, 3));

        g.setColor(Color.BLACK);
        g.fillRect(140, 340, 40, 60);

        for (int i = 0; i < myClouds.length; i++) {
            myClouds[i].drawMe(g);
        }
        
        for (int i = 0; i < myBirds.length; i++) {
            myBirds[i].drawMe(g);
        }

        for (int i = 0; i < myTrees.length; i++) {
            myTrees[i].drawMe(g);
        }

        for (int i = 0; i < myGrass.length; i++) {
            myGrass[i].drawMe(g);
        }
        
        myDog.drawMe(g);
    }

    public void animate() {
        while (true) {
            for (int i = 0; i < myClouds.length; i++) {
                myClouds[i].move();
            }
            
            myDog.move();
            
            for (int i = 0; i < myBirds.length; i++) {
                myBirds[i].move();
            }
            
            for (int i = 0; i < myFish.length; i++) {
                myFish[i].move();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            repaint();
        }
    }
}