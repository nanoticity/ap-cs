import javax.swing.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;
import java.io.ByteArrayInputStream;

public class Table extends JPanel implements ActionListener, KeyListener {

  public CardGame game;
  public String phase;
  public int currentPlayer;
  public int roundsPlayed;
  public int[] playerBets;
  public boolean[] playerFolded;
  public boolean roundDealt;
  public int playersActed;
  public int[] playerScores;
  public String roundWinnerText;
  public int[] playerWins;
  public String[] playerBestHand;
  public int[] playerBiggestWin;
  public String bonusText;
  public boolean cheatUsed;

  public Image clubsImg;
  public Image diamondsImg;
  public Image heartsImg;
  public Image spadesImg;

  public JButton startButton;
  public JButton betUpButton;
  public JButton betDownButton;
  public JButton dealButton;
  public JButton stayButton;
  public JButton foldButton;
  public JButton continueButton;
  public JButton nextRoundButton;
  public JButton endGameButton;

  public Table() {
    setLayout(null);
    setBackground(new Color(20, 100, 40));
    setFocusable(true);
    addKeyListener(this);

    try { clubsImg    = ImageIO.read(new File("clubs.png"));    } catch (Exception e) { clubsImg    = null; }
    try { diamondsImg = ImageIO.read(new File("diamonds.png")); } catch (Exception e) { diamondsImg = null; }
    try { heartsImg   = ImageIO.read(new File("hearts.png"));   } catch (Exception e) { heartsImg   = null; }
    try { spadesImg   = ImageIO.read(new File("spades.png"));   } catch (Exception e) { spadesImg   = null; }

    playerBets   = new int[2];
    playerFolded = new boolean[2];
    playerScores = new int[]{100, 100};
    playerWins   = new int[2];
    playerBestHand = new String[]{"None", "None"};
    playerBiggestWin = new int[2];
    roundWinnerText = "";
    bonusText = "";
    cheatUsed = false;

    startButton     = makeButton("START GAME",  375, 440, 250, 48);
    betUpButton     = makeButton("+ $5",        610, 250, 80, 42);
    betDownButton   = makeButton("- $5",        310, 250, 80, 42);
    dealButton      = makeButton("DEAL CARDS",  375, 440, 250, 48);
    stayButton      = makeButton("STAY IN",     230, 440, 210, 48);
    foldButton      = makeButton("FOLD",        560, 440, 210, 48);
    continueButton  = makeButton("CONTINUE",    375, 440, 250, 48);
    nextRoundButton = makeButton("NEXT ROUND",  275, 440, 200, 48);
    endGameButton   = makeButton("END GAME",    525, 440, 200, 48);

    add(startButton);     add(betUpButton);
    add(betDownButton);   add(dealButton);
    add(stayButton);      add(foldButton);
    add(continueButton);  add(nextRoundButton);
    add(endGameButton);

    startButton.addActionListener(this);
    betUpButton.addActionListener(this);
    betDownButton.addActionListener(this);
    dealButton.addActionListener(this);
    stayButton.addActionListener(this);
    foldButton.addActionListener(this);
    continueButton.addActionListener(this);
    nextRoundButton.addActionListener(this);
    endGameButton.addActionListener(this);

    startGame();
  }

  public JButton makeButton(String label, int x, int y, int w, int h) {
    JButton b = new JButton(label);
    b.setFont(new Font("Arial", Font.BOLD, 16));
    b.setBackground(Color.WHITE);
    b.setForeground(Color.BLACK);
    b.setFocusPainted(false);
    b.setOpaque(true);
    b.setBorderPainted(false);
    b.setBounds(x, y, w, h);
    return b;
  }

  public Dimension getPreferredSize() {
    return new Dimension(1000, 540);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (phase.equals("START")) {
      drawStart(g);
    } else if (phase.equals("BETTING")) {
      drawBetting(g);
    } else if (phase.equals("CARDS")) {
      drawCards(g);
    } else if (phase.equals("TRANSITION")) {
      drawTransition(g);
    } else if (phase.equals("RESULT")) {
      drawResult(g);
    } else if (phase.equals("ENDGAME")) {
      drawEndGame(g);
    }
  }

  public void drawStart(Graphics g) {
    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 56));
    g.drawString("3 CARD POKER", 255, 105);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("Two players take turns. Set your bet, then deal your three cards.", 205, 185);
    g.drawString("After seeing your hand, choose STAY IN to compete or FOLD to sit out.", 185, 220);
    g.drawString("The screen goes blank between turns so hands stay secret.", 240, 255);
    g.drawString("Each player starts with $100. Best hand wins the pot!", 260, 290);

    g.setColor(new Color(100, 255, 100));
    g.setFont(new Font("Arial", Font.BOLD, 18));
    g.drawString("BONUS PAYOUTS:  Pair 1x  |  Flush 2x  |  Straight 3x  |  Trips 4x  |  SF 5x", 145, 340);

    g.setColor(new Color(180, 230, 180));
    g.setFont(new Font("Arial", Font.PLAIN, 17));
    g.drawString("Hand Rankings: High Card < Pair < Flush < Straight < Three of a Kind < Straight Flush", 100, 385);
  }

  public void drawBetting(Graphics g) {
    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 48));
    g.drawString("PLAYER " + (currentPlayer + 1), 60, 85);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 24));
    g.drawString("Round " + (roundsPlayed + 1), 60, 135);
    g.drawString("Balance: $" + playerScores[currentPlayer], 60, 175);

    g.setColor(new Color(10, 70, 25));
    g.fillRoundRect(335, 220, 330, 62, 14, 14);
    g.setColor(new Color(255, 255, 255, 80));
    g.drawRoundRect(335, 220, 330, 62, 14, 14);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 34));
    g.drawString("Bet:  $" + playerBets[currentPlayer], 380, 262);

    g.setColor(new Color(180, 230, 180));
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    g.drawString("Use  - $5  and  + $5  to adjust your bet, then DEAL CARDS.", 270, 380);
  }

  public void drawCards(Graphics g) {
    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 42));
    g.drawString("PLAYER " + (currentPlayer + 1), 60, 72);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("Bet: $" + playerBets[currentPlayer] + "     Round " + (roundsPlayed + 1), 60, 112);

    ArrayList<Card> hand = game.getHand(currentPlayer);
    String handName = game.getHandName(hand);
    int[] eval = game.evaluateHand(hand);
    int handRank = eval[0];

    g.setColor(new Color(10, 70, 25));
    g.fillRoundRect(570, 80, 380, 42, 10, 10);
    Color rankColor = handRank >= 3 ? new Color(100, 255, 100) : new Color(255, 215, 0);
    g.setColor(rankColor);
    g.setFont(new Font("Arial", Font.BOLD, 22));
    g.drawString("Hand: " + handName + "  (Rank " + (handRank + 1) + "/6)", 585, 108);

    if (handRank >= 1) {
      int bonus = getBonusPayout(currentPlayer);
      g.setColor(new Color(100, 255, 100));
      g.setFont(new Font("Arial", Font.PLAIN, 16));
      g.drawString("Bonus payout: +$" + bonus, 600, 138);
    }

    int cardW = 105;
    int cardH = 148;
    int gap = 24;
    int startX = (1000 - (hand.size() * cardW + (hand.size() - 1) * gap)) / 2;
    for (int i = 0; i < hand.size(); i++) {
      drawCard(g, hand.get(i), startX + i * (cardW + gap), 145, cardW, cardH);
    }

    g.setColor(new Color(180, 230, 180));
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    g.drawString("STAY IN  to compete this round.     FOLD  to sit it out.", 295, 410);
  }

  public void drawCard(Graphics g, Card card, int x, int y, int w, int h) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(x, y, w, h, 12, 12);
    g.setColor(new Color(180, 180, 180));
    g.drawRoundRect(x, y, w, h, 12, 12);

    boolean red = card.getSuit().equals("hearts") || card.getSuit().equals("diamonds");
    Color ink = red ? new Color(200, 0, 0) : new Color(20, 20, 20);

    g.setColor(ink);
    g.setFont(new Font("Arial", Font.BOLD, 17));
    g.drawString(card.getRank(), x + 7, y + 22);
    g.drawString(card.getRank(), x + w - 7 - g.getFontMetrics().stringWidth(card.getRank()), y + h - 9);

    Image suitImg = getSuitImage(card.getSuit());
    if (suitImg != null) {
      g.drawImage(suitImg.getScaledInstance(46, 46, Image.SCALE_SMOOTH), x + (w - 46) / 2, y + (h - 46) / 2, null);
    }
  }

  public Image getSuitImage(String suit) {
    if (suit.equals("clubs"))    return clubsImg;
    if (suit.equals("diamonds")) return diamondsImg;
    if (suit.equals("hearts"))   return heartsImg;
    if (suit.equals("spades"))   return spadesImg;
    return null;
  }

  public void drawTransition(Graphics g) {
    g.setColor(new Color(20, 100, 40));
    g.fillRect(0, 0, getWidth(), getHeight());

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 42));
    g.drawString("PASS THE SCREEN", 265, 215);

    g.setFont(new Font("Arial", Font.PLAIN, 24));
    g.drawString("Player " + (currentPlayer + 1) + ", press CONTINUE when ready.", 255, 275);
  }

  public String getHandRankLabel(int rank) {
    String[] labels = {"High Card", "Pair", "Flush", "Straight", "Three of a Kind", "Straight Flush"};
    if (rank >= 0 && rank < labels.length) return labels[rank];
    return "???";
  }

  public void drawResult(Graphics g) {
    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 42));
    g.drawString("ROUND " + roundsPlayed + " COMPLETE", 255, 65);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 22));

    String p1Hand = playerFolded[0] ? "FOLDED" : game.getHandName(game.getHand(0));
    String p2Hand = playerFolded[1] ? "FOLDED" : game.getHandName(game.getHand(1));

    String p1Rank = playerFolded[0] ? "" : " (Rank " + (getHandRankValue(0) + 1) + "/6)";
    String p2Rank = playerFolded[1] ? "" : " (Rank " + (getHandRankValue(1) + 1) + "/6)";

    g.drawString("Player 1  --  Bet $" + playerBets[0] + "  --  " + p1Hand + p1Rank, 130, 135);
    g.drawString("Player 2  --  Bet $" + playerBets[1] + "  --  " + p2Hand + p2Rank, 130, 170);

    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 28));
    g.drawString(roundWinnerText, (1000 - g.getFontMetrics().stringWidth(roundWinnerText)) / 2, 230);

    if (bonusText.length() > 0) {
      g.setColor(new Color(100, 255, 100));
      g.setFont(new Font("Arial", Font.BOLD, 20));
      g.drawString(bonusText, (1000 - g.getFontMetrics().stringWidth(bonusText)) / 2, 265);
    }

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("Player 1 Balance: $" + playerScores[0], 340, 315);
    g.drawString("Player 2 Balance: $" + playerScores[1], 340, 350);

    g.setColor(new Color(180, 230, 180));
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    g.drawString("Press NEXT ROUND to keep playing or END GAME to finish.", 265, 410);
  }

  public void drawEndGame(Graphics g) {
    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 52));
    g.drawString("GAME OVER", 310, 70);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("Rounds Played: " + roundsPlayed, 400, 120);

    g.setColor(new Color(10, 70, 25));
    g.fillRoundRect(80, 145, 380, 240, 14, 14);
    g.fillRoundRect(540, 145, 380, 240, 14, 14);
    g.setColor(new Color(255, 255, 255, 60));
    g.drawRoundRect(80, 145, 380, 240, 14, 14);
    g.drawRoundRect(540, 145, 380, 240, 14, 14);

    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 26));
    g.drawString("Player 1", 210, 185);
    g.drawString("Player 2", 670, 185);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("Final Balance: $" + playerScores[0], 140, 225);
    g.drawString("Rounds Won: " + playerWins[0], 140, 255);
    int winPct1 = roundsPlayed > 0 ? (playerWins[0] * 100 / roundsPlayed) : 0;
    g.drawString("Win Rate: " + winPct1 + "%", 140, 285);
    g.drawString("Best Hand: " + playerBestHand[0], 140, 315);
    g.drawString("Biggest Win: $" + playerBiggestWin[0], 140, 345);

    g.drawString("Final Balance: $" + playerScores[1], 600, 225);
    g.drawString("Rounds Won: " + playerWins[1], 600, 255);
    int winPct2 = roundsPlayed > 0 ? (playerWins[1] * 100 / roundsPlayed) : 0;
    g.drawString("Win Rate: " + winPct2 + "%", 600, 285);
    g.drawString("Best Hand: " + playerBestHand[1], 600, 315);
    g.drawString("Biggest Win: $" + playerBiggestWin[1], 600, 345);

    String overallWinner;
    if (playerScores[0] > playerScores[1]) overallWinner = "PLAYER 1 WINS!";
    else if (playerScores[1] > playerScores[0]) overallWinner = "PLAYER 2 WINS!";
    else overallWinner = "IT'S A TIE!";

    g.setColor(new Color(255, 215, 0));
    g.setFont(new Font("Arial", Font.BOLD, 40));
    g.drawString(overallWinner, (1000 - g.getFontMetrics().stringWidth(overallWinner)) / 2, 420);

    g.setColor(new Color(180, 230, 180));
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    g.drawString("Press START GAME to play again.", 375, 470);
  }

  public int getHandRankValue(int player) {
    if (playerFolded[player]) return -1;
    int[] eval = game.evaluateHand(game.getHand(player));
    return eval[0];
  }

  public int getBonusPayout(int player) {
    int rank = getHandRankValue(player);
    int bet = playerBets[player];
    if (rank == 5) return bet * 5;
    if (rank == 4) return bet * 4;
    if (rank == 3) return bet * 3;
    if (rank == 2) return bet * 2;
    if (rank == 1) return bet;
    return 0;
  }

  public void updateBestHand(int player) {
    if (playerFolded[player]) return;
    int rank = getHandRankValue(player);
    String name = game.getHandName(game.getHand(player));
    String[] handOrder = {"High Card", "Pair", "Flush", "Straight", "Three of a Kind", "Straight Flush"};
    int currentBest = -1;
    for (int i = 0; i < handOrder.length; i++) {
      if (handOrder[i].equals(playerBestHand[player])) currentBest = i;
    }
    if (rank > currentBest) {
      playerBestHand[player] = name;
    }
  }

  public void resolveRound() {
    bonusText = "";

    updateBestHand(0);
    updateBestHand(1);

    if (playerFolded[0] && playerFolded[1]) {
      roundWinnerText = "Both players folded -- no payout!";
      playSound(false);
    } else if (playerFolded[0]) {
      int winnings = playerBets[0];
      playerScores[0] -= winnings;
      playerScores[1] += winnings;
      playerWins[1]++;
      if (winnings > playerBiggestWin[1]) playerBiggestWin[1] = winnings;
      roundWinnerText = "Player 2 wins $" + winnings + " (Player 1 folded)";
      playSound(true);
    } else if (playerFolded[1]) {
      int winnings = playerBets[1];
      playerScores[1] -= winnings;
      playerScores[0] += winnings;
      playerWins[0]++;
      if (winnings > playerBiggestWin[0]) playerBiggestWin[0] = winnings;
      roundWinnerText = "Player 1 wins $" + winnings + " (Player 2 folded)";
      playSound(true);
    } else {
      int bonus1 = getBonusPayout(0);
      int bonus2 = getBonusPayout(1);
      if (bonus1 > 0) playerScores[0] += bonus1;
      if (bonus2 > 0) playerScores[1] += bonus2;

      if (bonus1 > 0 || bonus2 > 0) {
        String b = "";
        if (bonus1 > 0) b += "P1 bonus +$" + bonus1;
        if (bonus1 > 0 && bonus2 > 0) b += "   ";
        if (bonus2 > 0) b += "P2 bonus +$" + bonus2;
        bonusText = b;
      }

      int result = game.compareHands();
      if (result == 1) {
        int winnings = playerBets[1];
        playerScores[0] += winnings;
        playerScores[1] -= winnings;
        playerWins[0]++;
        int total = winnings + bonus1;
        if (total > playerBiggestWin[0]) playerBiggestWin[0] = total;
        roundWinnerText = "Player 1 wins $" + winnings + "!";
        playSound(true);
      } else if (result == 2) {
        int winnings = playerBets[0];
        playerScores[1] += winnings;
        playerScores[0] -= winnings;
        playerWins[1]++;
        int total = winnings + bonus2;
        if (total > playerBiggestWin[1]) playerBiggestWin[1] = total;
        roundWinnerText = "Player 2 wins $" + winnings + "!";
        playSound(true);
      } else {
        roundWinnerText = "It's a tie -- no payout!";
        playSound(false);
      }
    }
  }

  public void playSound(boolean win) {
    if (win) {
      playTone(880.0, 150);
      playToneDelayed(1100.0, 200, 160);
    } else {
      playTone(330.0, 200);
    }
  }

  public void playFoldSound() {
    playTone(220.0, 150);
  }

  public void playGameOverSound() {
    playTone(660.0, 150);
    playToneDelayed(550.0, 150, 160);
    playToneDelayed(440.0, 300, 320);
  }

  public void playBetSound() {
    playTone(500.0, 80);
  }

  public void playTone(double freq, int durationMs) {
    try {
      float sampleRate = 44100;
      int numSamples = (int)(sampleRate * durationMs / 1000);
      byte[] buf = new byte[numSamples * 2];
      for (int i = 0; i < numSamples; i++) {
        double fade = 1.0 - ((double) i / numSamples);
        double angle = 2.0 * Math.PI * i * freq / sampleRate;
        short val = (short)(Math.sin(angle) * 20000 * fade);
        buf[i * 2] = (byte)(val & 0xFF);
        buf[i * 2 + 1] = (byte)((val >> 8) & 0xFF);
      }
      AudioFormat af = new AudioFormat(sampleRate, 16, 1, true, false);
      Clip clip = AudioSystem.getClip();
      clip.open(af, buf, 0, buf.length);
      clip.start();
    } catch (Exception e) {}
  }

  public void playToneDelayed(double freq, int durationMs, int delayMs) {
    new Thread(() -> {
      try { Thread.sleep(delayMs); } catch (Exception e) {}
      playTone(freq, durationMs);
    }).start();
  }

  public void startGame() {
    phase = "START";
    currentPlayer = 0;
    roundsPlayed = 0;
    playersActed = 0;
    roundDealt = false;
    playerBets[0] = 10;
    playerBets[1] = 10;
    playerFolded[0] = false;
    playerFolded[1] = false;
    playerScores[0] = 100;
    playerScores[1] = 100;
    playerWins[0] = 0;
    playerWins[1] = 0;
    playerBestHand[0] = "None";
    playerBestHand[1] = "None";
    playerBiggestWin[0] = 0;
    playerBiggestWin[1] = 0;
    roundWinnerText = "";
    bonusText = "";
    cheatUsed = false;
    game = new CardGame();
    updateButtons();
    repaint();
  }

  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();

    if (src == startButton) {
      currentPlayer = 0;
      roundsPlayed = 0;
      playersActed = 0;
      roundDealt = false;
      playerBets[0] = 10;
      playerBets[1] = 10;
      playerFolded[0] = false;
      playerFolded[1] = false;
      playerScores[0] = 100;
      playerScores[1] = 100;
      playerWins[0] = 0;
      playerWins[1] = 0;
      playerBestHand[0] = "None";
      playerBestHand[1] = "None";
      playerBiggestWin[0] = 0;
      playerBiggestWin[1] = 0;
      bonusText = "";
      cheatUsed = false;
      game = new CardGame();
      phase = "BETTING";

    } else if (src == betUpButton) {
      if (playerBets[currentPlayer] < playerScores[currentPlayer]) {
        playerBets[currentPlayer] += 5;
        playBetSound();
      }

    } else if (src == betDownButton) {
      if (playerBets[currentPlayer] > 5) {
        playerBets[currentPlayer] -= 5;
        playBetSound();
      }

    } else if (src == dealButton) {
      if (!roundDealt) {
        game.startRound();
        roundDealt = true;
        playSound(false);
      }
      phase = "CARDS";

    } else if (src == stayButton) {
      playerFolded[currentPlayer] = false;
      playersActed++;
      if (playersActed < 2) {
        currentPlayer = 1;
        phase = "TRANSITION";
      } else {
        roundsPlayed++;
        playersActed = 0;
        resolveRound();
        phase = "RESULT";
      }

    } else if (src == foldButton) {
      playerFolded[currentPlayer] = true;
      playFoldSound();
      playersActed++;
      if (playersActed < 2) {
        currentPlayer = 1;
        phase = "TRANSITION";
      } else {
        roundsPlayed++;
        playersActed = 0;
        resolveRound();
        phase = "RESULT";
      }

    } else if (src == continueButton) {
      playerBets[currentPlayer] = Math.min(10, playerScores[currentPlayer]);
      phase = "BETTING";

    } else if (src == nextRoundButton) {
      currentPlayer = 0;
      roundDealt = false;
      playersActed = 0;
      playerBets[0] = Math.min(10, playerScores[0]);
      playerBets[1] = Math.min(10, playerScores[1]);
      playerFolded[0] = false;
      playerFolded[1] = false;
      phase = "BETTING";

    } else if (src == endGameButton) {
      phase = "ENDGAME";
      playGameOverSound();
    }

    updateButtons();
    repaint();
    requestFocusInWindow();
  }

  public void keyPressed(KeyEvent e) {
    char key = e.getKeyChar();

    if (key == 'c' || key == 'C') {
      if (phase.equals("BETTING") || phase.equals("CARDS")) {
        playerScores[currentPlayer] += 50;
        cheatUsed = true;
        playSound(true);
        repaint();
      }
    }

    if (key == 'p' || key == 'P') {
      if (phase.equals("START")) {
        game = new CardGame();
        game.startRound();
        roundDealt = true;
        phase = "BETTING";
      } else if (phase.equals("BETTING")) {
        if (!roundDealt) {
          game.startRound();
          roundDealt = true;
        }
        phase = "CARDS";
      } else if (phase.equals("CARDS")) {
        playerFolded[currentPlayer] = false;
        playersActed++;
        if (playersActed < 2) {
          currentPlayer = 1;
          phase = "TRANSITION";
        } else {
          roundsPlayed++;
          playersActed = 0;
          resolveRound();
          phase = "RESULT";
        }
      } else if (phase.equals("TRANSITION")) {
        playerBets[currentPlayer] = Math.min(10, playerScores[currentPlayer]);
        phase = "BETTING";
      } else if (phase.equals("RESULT")) {
        phase = "ENDGAME";
      } else if (phase.equals("ENDGAME")) {
        startGame();
        phase = "START";
      }
      updateButtons();
      repaint();
    }
  }

  public void keyReleased(KeyEvent e) {}
  public void keyTyped(KeyEvent e) {}

  public void updateButtons() {
    startButton.setVisible(phase.equals("START") || phase.equals("ENDGAME"));
    betUpButton.setVisible(phase.equals("BETTING"));
    betDownButton.setVisible(phase.equals("BETTING"));
    dealButton.setVisible(phase.equals("BETTING"));
    stayButton.setVisible(phase.equals("CARDS"));
    foldButton.setVisible(phase.equals("CARDS"));
    continueButton.setVisible(phase.equals("TRANSITION"));
    nextRoundButton.setVisible(phase.equals("RESULT"));
    endGameButton.setVisible(phase.equals("RESULT"));
  }
}
