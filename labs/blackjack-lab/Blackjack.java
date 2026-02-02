import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Blackjack {
  private Card[] deck;
  private Card[] playerHand;
  private int deckIndex;
  private int handSize;
  private int playerPoints;
  private boolean gameActive;
  private boolean gameOver;
  private int handValue;

  public Blackjack() {
    deck = new Card[52];
    playerHand = new Card[20];
    playerPoints = 20;
    deckIndex = 0;
    handSize = 0;
    gameActive = false;
    gameOver = false;
    initializeDeck();
  }

  private void initializeDeck() {
    String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    String[] names = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
    
    int index = 0;
    for (String suit : suits) {
      for (int i = 0; i < names.length; i++) {
        deck[index] = new Card(values[i], names[i], suit);
        index++;
      }
    }
  }

  private void shuffleDeck() {
    for (int i = 0; i < 1000; i++) {
      int index1 = (int)(Math.random() * 52);
      int index2 = (int)(Math.random() * 52);
      Card temp = deck[index1];
      deck[index1] = deck[index2];
      deck[index2] = temp;
    }
  }

  public void startNewGame() {
    if (playerPoints <= 0) {
      return;
    }
    playerPoints--;
    shuffleDeck();
    deckIndex = 0;
    handSize = 0;
    gameActive = true;
    gameOver = false;
    
    playerHand[handSize++] = deck[deckIndex++];
    playerHand[handSize++] = deck[deckIndex++];
    calculateHandValue();
  }

  public void hit() {
    if (!gameActive || gameOver) {
      return;
    }
    
    playerHand[handSize++] = deck[deckIndex++];
    calculateHandValue();
    
    if (handValue > 21) {
      gameOver = true;
      gameActive = false;
    }
  }

  public void stand() {
    if (!gameActive || gameOver) {
      return;
    }
    
    gameOver = true;
    gameActive = false;
    
    if (handValue >= 16 && handValue <= 21) {
      int pointsWon = getPointsForValue(handValue);
      playerPoints += pointsWon;
    }
  }

  private int getPointsForValue(int value) {
    if (value == 21) return 5;
    if (value == 20) return 3;
    if (value == 19 || value == 18) return 2;
    if (value == 17 || value == 16) return 1;
    return 0;
  }

  private void calculateHandValue() {
    handValue = 0;
    for (int i = 0; i < handSize; i++) {
      handValue += playerHand[i].getValue();
    }
  }

  public void drawGame(Graphics g) {
    g.setColor(new Color(0, 100, 0));
    g.fillRect(0, 0, 1000, 600);
    
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 24));
    g.drawString("Total Points: " + playerPoints, 50, 40);
    
    if (gameActive || gameOver) {
      g.drawString("Hand Value: " + handValue, 50, 80);
      
      for (int i = 0; i < handSize; i++) {
        playerHand[i].drawMe(g, 50 + i * 120, 120);
      }
      
      if (gameOver) {
        g.setFont(new Font("Arial", Font.BOLD, 36));
        if (handValue > 21) {
          g.setColor(Color.RED);
          g.drawString("BUST! You Lost!", 350, 350);
        } else if (handValue >= 16) {
          g.setColor(Color.YELLOW);
          int pointsWon = getPointsForValue(handValue);
          g.drawString("You Won " + pointsWon + " Points!", 350, 350);
        } else {
          g.setColor(Color.RED);
          g.drawString("Too Low! You Lost!", 350, 350);
        }
      }
    } else {
      g.setFont(new Font("Arial", Font.BOLD, 28));
      g.drawString("Press 'Play Again' to start", 300, 300);
    }
    
    drawPointsTable(g);
  }

  private void drawPointsTable(Graphics g) {
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 18));
    g.drawString("Points Table:", 700, 100);
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    g.drawString("21 - 5 points", 700, 130);
    g.drawString("20 - 3 points", 700, 155);
    g.drawString("19 - 2 points", 700, 180);
    g.drawString("18 - 2 points", 700, 205);
    g.drawString("17 - 1 point", 700, 230);
    g.drawString("16 - 1 point", 700, 255);
  }

  public boolean isGameActive() {
    return gameActive;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public int getHandValue() {
    return handValue;
  }

  public boolean canPlayAgain() {
    return playerPoints > 0;
  }
}
