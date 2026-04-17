import java.awt.Graphics;

public class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }

  public void printInfo() {
    super.speak();
    System.out.println(getName());
    System.out.println("I make the sound ");
    this.speak();
  }

  public void speak() {
    System.out.println("meow");
  }

  public void drawMe(Graphics g, int x, int y) {
    super.drawMe(g, x, y);
    
    g.fillOval(x + 15, y - 25, 30, 30);
    
    g.drawLine(x + 5, y - 10, x - 10, y - 15);
    g.drawLine(x + 5, y - 5, x - 10, y - 5);
    g.drawLine(x + 5, y, x - 10, y + 5);
    
    g.drawLine(x + 55, y - 10, x + 70, y - 15);
    g.drawLine(x + 55, y - 5, x + 70, y - 5);
    g.drawLine(x + 55, y, x + 70, y + 5);
    
    g.fillOval(x + 20, y - 18, 5, 5);
    g.fillOval(x + 35, y - 18, 5, 5);
  }
}
