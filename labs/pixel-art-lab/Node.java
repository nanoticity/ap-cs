import java.awt.Graphics;
import java.awt.Color;

public class Node {
  private int r, g, b;
  private ColorCode cc;
  private static final int BORDER_SIZE = 1;

  public Node(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  private enum ColorCode {
    WHITE,
    BLACK,
    RED,
    BLUE,
    YELLOW,
    GREEN,
    DARK_RED
  }

  public void drawMe(int x, int y, int size, Graphics graphics) {
    graphics.setColor(new Color(r, g, b));
    graphics.fillRect(x, y, size, size);

    graphics.setColor(Color.BLACK);
    graphics.drawRect(x, y, size, size);
  }

  public void setColor(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public int getR() {
    return r;
  }

  public int getG() {
    return g;
  }

  public int getB() {
    return b;
  }

  public int getColorCode() {
    if (r == 255 && g == 255 && b == 255)
      return 0;
    if (r == 0 && g == 0 && b == 0)
      return 1;
    if (r == 255 && g == 0 && b == 0)
      return 2;
    if (r == 0 && g == 0 && b == 255)
      return 3;
    if (r == 255 && g == 255 && b == 0)
      return 4;
    if (r == 0 && g == 128 && b == 0)
      return 5;
    if (r == 128 && g == 0 && b == 128)
      return 6;
    return 0;
  }

  public static void setColorFromCode(Node node, int code) {
    switch (code) {
      case 0:
        node.setColor(255, 255, 255);
        break;
      case 1:
        node.setColor(0, 0, 0);
        break;
      case 2:
        node.setColor(255, 0, 0);
        break;
      case 3:
        node.setColor(0, 0, 255);
        break;
      case 4:
        node.setColor(255, 255, 0);
        break;
      case 5:
        node.setColor(0, 128, 0);
        break;
      case 6:
        node.setColor(128, 0, 128);
        break;
      default:
        node.setColor(255, 255, 255);
    }
  }
}