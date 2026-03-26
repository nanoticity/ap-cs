import java.awt.Graphics;

public class Animal {
  private String name;

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void speak() {
    System.out.println("Hello, my name is " + name);
  }

  public void drawMe(Graphics g, int x, int y) {
    g.drawRect(x, y, 60, 80);
  }
}
