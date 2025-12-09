import java.awt.Color;
import java.awt.Graphics;


public class Game {
    private Projectile p1;
	private Ship s1;


    public Game() {
        s1 = new Ship(50, 300);
        p1 = new Projectile(50, 300);
    }


    public void drawMe(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);


        // Draw ship
        s1.drawMe(g);


        // Draw Projectile
        p1.drawMe(g);
    }


    public void movePlayer(String direction) {
        if (direction.equals("up")) {
            s1.moveUp();
        } else if (direction.equals("down")) {
            s1.moveDown();
        }
    }



    public void playerShoot() {
        System.out.println("Shoot");
    }


}
