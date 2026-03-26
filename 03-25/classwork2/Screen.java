import javax.swing.JPanel;
import java.awt.Graphics;

public class Screen extends JPanel {
  private Dog dog;
  private Cat cat;
  private Bird bird;

  public Screen() {
    dog = new Dog("Fido");
    cat = new Cat("Felix");
    bird = new Bird("Tweety");
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    String dogName = dog.getName();
    g.drawString(dogName, 50, 60);
    dog.drawMe(g, 50, 80);
    
    String catName = cat.getName();
    g.drawString(catName, 200, 60);
    cat.drawMe(g, 200, 80);
    
    String birdName = bird.getName();
    g.drawString(birdName, 350, 60);
    bird.drawMe(g, 350, 80);
  }
}
