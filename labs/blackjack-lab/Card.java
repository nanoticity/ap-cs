import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card {
  private int value;
  private String name;
  private String suit;

  private BufferedImage suitImage;

  public Card(int value, String name, String suit) {
    this.value = value;
    this.name = name;
    this.suit = suit;
    loadSuitImage();
  }

  private void loadSuitImage() {
    try {
      if (suit.equals("Hearts")) {
        suitImage = ImageIO.read(new File("hearts.png"));
      } else if (suit.equals("Diamonds")) {
        suitImage = ImageIO.read(new File("diamond.png"));
      } else if (suit.equals("Spades")) {
        suitImage = ImageIO.read(new File("spade.png"));
      } else if (suit.equals("Clubs")) {
        suitImage = ImageIO.read(new File("clover.png"));
      }
    } catch (IOException e) {
      System.out.println("Error loading image: " + e);
    }
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public String getSuit() {
    return suit;
  }

  public void drawMe(Graphics g, int x, int y) {
    g.setColor(Color.WHITE);
    g.fillRect(x, y, 100, 150);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, 100, 150);
    g.setFont(new Font("Arial", Font.BOLD, 24));
    
    if (suit.equals("Hearts") || suit.equals("Diamonds")) {
      g.setColor(Color.RED);
    } else {
      g.setColor(Color.BLACK);
    }
    
    g.drawString(name, x + 10, y + 30);
    
    if (suitImage != null) {
      g.drawImage(suitImage, x + 30, y + 60, 40, 40, null);
    }
  }

}
