import java.awt.Graphics;

public class Bird extends Animal {
  public Bird(String name) {
    super(name);
  }

  public void printInfo() {
    super.speak();
    System.out.println(getName());
    System.out.println("I make the sound ");
    this.speak();
  }

  public void speak() {
    System.out.println("tweet");
  }

  public void drawMe(Graphics g, int x, int y) {
    super.drawMe(g, x, y);
    
    g.fillOval(x - 15, y + 20, 30, 20);
    g.fillOval(x + 45, y + 20, 30, 20);
    
    g.fillOval(x + 20, y - 20, 20, 20);
    
    g.fillPolygon(new int[]{x + 30, x + 35, x + 30}, new int[]{y - 5, y - 10, y - 10}, 3);
  }
}
