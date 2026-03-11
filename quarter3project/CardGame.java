import java.util.ArrayList;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;

public class CardGame {
  ArrayList<Card> deck;
  ArrayList<Card> hand1;
  ArrayList<Card> hand2;

  Image clubsImg;
  Image diamondsImg;
  Image heartsImg;
  Image spadesImg;

  public CardGame() {
    deck = new ArrayList<Card>();
    hand1 = new ArrayList<Card>();
    hand2 = new ArrayList<Card>();

    try {
      clubsImg = ImageIO.read(new File("clubs.png"));
    } catch (Exception e) {
    }
    try {
      diamondsImg = ImageIO.read(new File("diamonds.png"));
    } catch (Exception e) {
    }
    try {
      heartsImg = ImageIO.read(new File("hearts.png"));
    } catch (Exception e) {
    }
    try {
      spadesImg = ImageIO.read(new File("spades.png"));
    } catch (Exception e) {
    }
  }

  public void makeDeck() {
    deck.clear();
    String[] suits = { "clubs", "diamonds", "hearts", "spades" };
    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
    for (int i = 0; i < suits.length; i++) {
      for (int j = 0; j < ranks.length; j++) {
        deck.add(new Card(suits[i], ranks[j]));
      }
    }
  }

  public void shuffle(ArrayList<Card> list) {
    for (int i = list.size() - 1; i > 0; i--) {
      int j = (int) (Math.random() * (i + 1));
      Card temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
    }
  }

  public void deal() {
    makeDeck();
    shuffle(deck);
    hand1.clear();
    hand2.clear();
    for (int i = 0; i < 3; i++) {

      hand1.add(deck.remove(0));
      hand2.add(deck.remove(0));
    }
  }

  public ArrayList<Card> getHand(int player) {
    if (player == 0)
      return hand1;
    return hand2;
  }

  public int[] sortThree(int a, int b, int c) {
    int[] arr = { a, b, c };
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] < arr[j + 1]) {
          int t = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = t;
        }
      }
    }
    return arr;
  }

  public int[] evaluate(ArrayList<Card> hand) {
    int[] sorted = sortThree(hand.get(0).getValue(), hand.get(1).getValue(), hand.get(2).getValue());
    int high = sorted[0];
    int mid = sorted[1];
    int low = sorted[2];

    boolean isFlush = false;
    if (hand.get(0).suit.equals(hand.get(1).suit) && hand.get(1).suit.equals(hand.get(2).suit))
      isFlush = true;

    boolean isStraight = false;
    if (high - mid == 1 && mid - low == 1)
      isStraight = true;

    if (high == 14 && mid == 3 && low == 2) {
      isStraight = true;
      high = 3;
      mid = 2;
      low = 1;
    }

    int type = 0;
    if (isStraight && isFlush)
      type = 5;
    else if (high == mid && mid == low)
      type = 4;
    else if (isStraight)
      type = 3;
    else if (isFlush)
      type = 2;
    else if (high == mid || mid == low)
      type = 1;

    if (type == 1 && mid == low) {
      int kicker = high;
      high = mid;
      mid = kicker;
      low = 0;
    }

    return new int[] { type, high, mid, low };
  }

  public String handName(ArrayList<Card> hand) {
    int type = evaluate(hand)[0];
    if (type == 5)
      return "Straight Flush";
    if (type == 4)
      return "Three of a Kind";
    if (type == 3)
      return "Straight";
    if (type == 2)
      return "Flush";
    if (type == 1)
      return "Pair";
    return "High Card";
  }

  public int compare() {
    int[] e1 = evaluate(hand1);
    int[] e2 = evaluate(hand2);
    for (int i = 0; i < e1.length; i++) {
      if (e1[i] > e2[i])
        return 1;
      if (e1[i] < e2[i])
        return 2;
    }
    return 0;
  }

  public int getBonus(int handType) {
    if (handType == 5)
      return 5;
    if (handType == 4)
      return 4;
    if (handType == 3)
      return 3;
    if (handType == 2)
      return 2;
    if (handType == 1)
      return 1;
    return 0;
  }

  public int getPairPlusBonus(int handType) {
    if (handType == 5)
      return 40;
    if (handType == 4)
      return 30;
    if (handType == 3)
      return 6;
    if (handType == 2)
      return 4;
    if (handType == 1)
      return 1;
    return 0;
  }

  public Image getSuitImg(String suit) {
    if (suit.equals("clubs"))
      return clubsImg;
    if (suit.equals("diamonds"))
      return diamondsImg;
    if (suit.equals("hearts"))
      return heartsImg;
    if (suit.equals("spades"))
      return spadesImg;
    return null;
  }

  public void drawCard(Graphics g, Card c, int x, int y, int w, int h) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(x, y, w, h, 12, 12);
    g.setColor(Color.GRAY);
    g.drawRoundRect(x, y, w, h, 12, 12);

    if (c.suit.equals("hearts") || c.suit.equals("diamonds"))
      g.setColor(Color.RED);
    else
      g.setColor(Color.BLACK);
    g.setFont(new Font("Arial", Font.BOLD, 17));
    g.drawString(c.rank, x + 7, y + 22);

    Image img = getSuitImg(c.suit);
    if (img != null) {
      int ix = x + (w - 46) / 2;
      int iy = y + (h - 46) / 2;
      g.drawImage(img.getScaledInstance(46, 46, Image.SCALE_SMOOTH), ix, iy, null);
    }
  }

  public void drawHand(Graphics g, ArrayList<Card> hand, int centerX, int topY) {
    int cardW = 105;
    int cardH = 148;
    int gap = 24;
    int startX = centerX - (3 * cardW + 2 * gap) / 2;
    for (int i = 0; i < hand.size(); i++) {
      drawCard(g, hand.get(i), startX + i * (cardW + gap), topY, cardW, cardH);
    }
  }
}
