import java.awt.Graphics;

public class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  public void printInfo() {
    super.speak();
    System.out.println(getName());
    System.out.println("I make the sound ");
    this.speak();
  }

  public void speak() {
    System.out.println("woof");
  }

  public void drawMe(Graphics g, int x, int y) {
    super.drawMe(g, x, y);
    
    g.fillOval(x + 15, y - 25, 30, 30);
    
    g.fillOval(x + 20, y - 18, 5, 5);
    g.fillOval(x + 35, y - 18, 5, 5);
    
    g.fillRect(x + 5, y - 35, 10, 15);
    g.fillRect(x + 45, y - 35, 10, 15);
  }
}
