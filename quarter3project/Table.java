import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;

public class Table extends JPanel implements ActionListener, KeyListener {

  CardGame game;
  String phase;
  int currentPlayer;
  int roundNum;
  int[] bets;
  boolean[] folded;
  int[] money;
  boolean dealt;
  int turnsDone;
  String resultMsg;
  int[] wins;
  String bonusMsg;

  JButton startBtn;
  JButton betUpBtn;
  JButton betDownBtn;
  JButton dealBtn;
  JButton stayBtn;
  JButton foldBtn;
  JButton continueBtn;
  JButton nextBtn;
  JButton endBtn;

  public Table() {
    setLayout(null);
    setBackground(new Color(20, 100, 40));
    setFocusable(true);
    addKeyListener(this);

    bets = new int[2];
    bets[0] = 10;
    bets[1] = 10;
    folded = new boolean[2];
    money = new int[2];
    money[0] = 100;
    money[1] = 100;
    wins = new int[2];
    resultMsg = "";
    bonusMsg = "";

    startBtn = makeBtn("START GAME", 375, 440, 250, 48);
    betUpBtn = makeBtn("+ $5", 610, 250, 80, 42);
    betDownBtn = makeBtn("- $5", 310, 250, 80, 42);
    dealBtn = makeBtn("DEAL CARDS", 375, 440, 250, 48);
    stayBtn = makeBtn("STAY IN", 230, 440, 210, 48);
    foldBtn = makeBtn("FOLD", 560, 440, 210, 48);
    continueBtn = makeBtn("CONTINUE", 375, 440, 250, 48);
    nextBtn = makeBtn("NEXT ROUND", 275, 440, 200, 48);
    endBtn = makeBtn("END GAME", 525, 440, 200, 48);

    add(startBtn);
    add(betUpBtn);
    add(betDownBtn);
    add(dealBtn);
    add(stayBtn);
    add(foldBtn);
    add(continueBtn);
    add(nextBtn);
    add(endBtn);

    startBtn.addActionListener(this);
    betUpBtn.addActionListener(this);
    betDownBtn.addActionListener(this);
    dealBtn.addActionListener(this);
    stayBtn.addActionListener(this);
    foldBtn.addActionListener(this);
    continueBtn.addActionListener(this);
    nextBtn.addActionListener(this);
    endBtn.addActionListener(this);

    game = new CardGame();
    phase = "START";
    showButtons();
  }

  public JButton makeBtn(String text, int x, int y, int w, int h) {
    JButton b = new JButton(text);
    b.setFont(new Font("Arial", Font.BOLD, 16));
    b.setBackground(Color.WHITE);
    b.setFocusPainted(false);
    b.setOpaque(true);
    b.setBorderPainted(false);
    b.setBounds(x, y, w, h);
    return b;
  }

  public Dimension getPreferredSize() {
    return new Dimension(1000, 540);
  }

  // plays a wav file
  public void playSound(String filename) {
    try {
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(new File(filename)));
      clip.start();
    } catch (Exception e) {}
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (phase.equals("START")) {
      // title screen
      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 56));
      g.drawString("3 CARD POKER", 255, 105);

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 20));
      g.drawString("Two players take turns betting and playing 3-card hands.", 200, 200);
      g.drawString("Set your bet, deal your cards, then stay or fold.", 230, 240);
      g.drawString("Each player starts with $100. Best hand wins the pot!", 220, 280);

      g.setColor(new Color(100, 255, 100));
      g.setFont(new Font("Arial", Font.BOLD, 17));
      g.drawString("Bonus payouts: Pair 1x | Flush 2x | Straight 3x | Trips 4x | SF 5x", 160, 330);

      g.setFont(new Font("Arial", Font.PLAIN, 17));
      g.setColor(new Color(180, 230, 180));
      g.drawString("Rankings: High Card < Pair < Flush < Straight < Three of a Kind < Straight Flush", 100, 370);

    } else if (phase.equals("BETTING")) {
      // betting screen
      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 48));
      g.drawString("PLAYER " + (currentPlayer + 1), 60, 85);

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 24));
      g.drawString("Round " + (roundNum + 1), 60, 135);
      g.drawString("Balance: $" + money[currentPlayer], 60, 175);

      g.setFont(new Font("Arial", Font.BOLD, 34));
      g.drawString("Bet:  $" + bets[currentPlayer], 400, 262);

      g.setFont(new Font("Arial", Font.PLAIN, 16));
      g.setColor(new Color(180, 230, 180));
      g.drawString("Use the buttons to set your bet, then press DEAL CARDS.", 270, 380);

    } else if (phase.equals("CARDS")) {
      // showing hand
      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 42));
      g.drawString("PLAYER " + (currentPlayer + 1), 60, 72);

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 20));
      g.drawString("Bet: $" + bets[currentPlayer], 60, 112);

      ArrayList<Card> hand = game.getHand(currentPlayer);
      String name = game.handName(hand);
      int handType = game.evaluate(hand)[0];

      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 22));
      g.drawString("Hand: " + name, 600, 100);

      // show bonus info if they have a pair or better
      if (handType >= 1) {
        int bonus = game.getBonus(handType) * bets[currentPlayer];
        g.setColor(new Color(100, 255, 100));
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Bonus payout: +$" + bonus, 600, 125);
      }

      // draw the cards using CardGame
      game.drawHand(g, hand, 500, 145);

      g.setColor(new Color(180, 230, 180));
      g.setFont(new Font("Arial", Font.PLAIN, 16));
      g.drawString("Choose STAY IN or FOLD.", 395, 410);

    } else if (phase.equals("TRANSITION")) {
      // pass screen between players
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.BOLD, 42));
      g.drawString("PASS THE SCREEN", 265, 215);
      g.setFont(new Font("Arial", Font.PLAIN, 24));
      g.drawString("Player " + (currentPlayer + 1) + ", press CONTINUE when ready.", 255, 275);

    } else if (phase.equals("RESULT")) {
      // round result
      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 42));
      g.drawString("ROUND " + roundNum + " RESULT", 280, 70);

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 22));
      String h1 = folded[0] ? "FOLDED" : game.handName(game.hand1);
      String h2 = folded[1] ? "FOLDED" : game.handName(game.hand2);
      g.drawString("Player 1:  Bet $" + bets[0] + "  -  " + h1, 150, 150);
      g.drawString("Player 2:  Bet $" + bets[1] + "  -  " + h2, 150, 190);

      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 28));
      int tw = g.getFontMetrics().stringWidth(resultMsg);
      g.drawString(resultMsg, (1000 - tw) / 2, 250);

      if (bonusMsg.length() > 0) {
        g.setColor(new Color(100, 255, 100));
        g.setFont(new Font("Arial", Font.BOLD, 20));
        int bw = g.getFontMetrics().stringWidth(bonusMsg);
        g.drawString(bonusMsg, (1000 - bw) / 2, 285);
      }

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 20));
      g.drawString("Player 1 Balance: $" + money[0], 350, 330);
      g.drawString("Player 2 Balance: $" + money[1], 350, 365);

    } else if (phase.equals("ENDGAME")) {
      // final screen
      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 52));
      g.drawString("GAME OVER", 310, 80);

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 22));
      g.drawString("Rounds Played: " + roundNum, 380, 140);

      g.drawString("Player 1 Final Balance: $" + money[0], 310, 200);
      g.drawString("Player 1 Rounds Won: " + wins[0], 310, 230);

      g.drawString("Player 2 Final Balance: $" + money[1], 310, 290);
      g.drawString("Player 2 Rounds Won: " + wins[1], 310, 320);

      // figure out overall winner
      String winner = "IT'S A TIE!";
      if (money[0] > money[1])
        winner = "PLAYER 1 WINS!";
      else if (money[1] > money[0])
        winner = "PLAYER 2 WINS!";

      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 40));
      int tw = g.getFontMetrics().stringWidth(winner);
      g.drawString(winner, (1000 - tw) / 2, 400);

      g.setColor(new Color(180, 230, 180));
      g.setFont(new Font("Arial", Font.PLAIN, 16));
      g.drawString("Press START GAME to play again.", 375, 470);
    }
  }

  public void figureOutWinner() {
    bonusMsg = "";

    if (folded[0] && folded[1]) {
      resultMsg = "Both players folded - no payout!";
      playSound("lose.wav");
      return;
    }

    if (folded[0]) {
      money[0] -= bets[0];
      money[1] += bets[0];
      wins[1]++;
      resultMsg = "Player 2 wins $" + bets[0] + " (Player 1 folded)";
      playSound("win.wav");
      return;
    }

    if (folded[1]) {
      money[1] -= bets[1];
      money[0] += bets[1];
      wins[0]++;
      resultMsg = "Player 1 wins $" + bets[1] + " (Player 2 folded)";
      playSound("win.wav");
      return;
    }

    // award bonus payouts
    int bonus1 = game.getBonus(game.evaluate(game.hand1)[0]) * bets[0];
    int bonus2 = game.getBonus(game.evaluate(game.hand2)[0]) * bets[1];
    if (bonus1 > 0)
      money[0] += bonus1;
    if (bonus2 > 0)
      money[1] += bonus2;

    if (bonus1 > 0 || bonus2 > 0) {
      String b = "";
      if (bonus1 > 0) b += "P1 bonus +$" + bonus1;
      if (bonus1 > 0 && bonus2 > 0) b += "   ";
      if (bonus2 > 0) b += "P2 bonus +$" + bonus2;
      bonusMsg = b;
    }

    // compare hands
    int winner = game.compare();
    if (winner == 1) {
      money[0] += bets[1];
      money[1] -= bets[1];
      wins[0]++;
      resultMsg = "Player 1 wins $" + bets[1] + "!";
      playSound("win.wav");
    } else if (winner == 2) {
      money[1] += bets[0];
      money[0] -= bets[0];
      wins[1]++;
      resultMsg = "Player 2 wins $" + bets[0] + "!";
      playSound("win.wav");
    } else {
      resultMsg = "It's a tie - no payout!";
      playSound("lose.wav");
    }
  }

  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();

    if (src == startBtn) {
      resetGame();
      phase = "BETTING";
    }

    if (src == betUpBtn) {
      if (bets[currentPlayer] < money[currentPlayer])
        bets[currentPlayer] += 5;
    }

    if (src == betDownBtn) {
      if (bets[currentPlayer] > 5)
        bets[currentPlayer] -= 5;
    }

    if (src == dealBtn) {
      if (!dealt) {
        game.deal();
        dealt = true;
      }
      phase = "CARDS";
    }

    if (src == stayBtn || src == foldBtn) {
      if (src == foldBtn) {
        folded[currentPlayer] = true;
        playSound("lose.wav");
      }

      turnsDone++;
      if (turnsDone < 2) {
        currentPlayer = 1;
        phase = "TRANSITION";
      } else {
        roundNum++;
        turnsDone = 0;
        figureOutWinner();
        phase = "RESULT";
      }
    }

    if (src == continueBtn) {
      bets[currentPlayer] = Math.min(10, money[currentPlayer]);
      phase = "BETTING";
    }

    if (src == nextBtn) {
      currentPlayer = 0;
      dealt = false;
      turnsDone = 0;
      bets[0] = Math.min(10, money[0]);
      bets[1] = Math.min(10, money[1]);
      folded[0] = false;
      folded[1] = false;
      phase = "BETTING";
    }

    if (src == endBtn) {
      phase = "ENDGAME";
    }

    showButtons();
    repaint();
    requestFocusInWindow();
  }

  // cheat key - p progresses through screens
  public void keyPressed(KeyEvent e) {
    char key = e.getKeyChar();

    if (key == 'p' || key == 'P') {
      if (phase.equals("START")) {
        resetGame();
        game.deal();
        dealt = true;
        phase = "BETTING";
      } else if (phase.equals("BETTING")) {
        if (!dealt) {
          game.deal();
          dealt = true;
        }
        phase = "CARDS";
      } else if (phase.equals("CARDS")) {
        turnsDone++;
        if (turnsDone < 2) {
          currentPlayer = 1;
          phase = "TRANSITION";
        } else {
          roundNum++;
          turnsDone = 0;
          figureOutWinner();
          phase = "RESULT";
        }
      } else if (phase.equals("TRANSITION")) {
        bets[currentPlayer] = Math.min(10, money[currentPlayer]);
        phase = "BETTING";
      } else if (phase.equals("RESULT")) {
        phase = "ENDGAME";
      } else if (phase.equals("ENDGAME")) {
        resetGame();
        phase = "START";
      }

      showButtons();
      repaint();
    }
  }

  public void keyReleased(KeyEvent e) {}
  public void keyTyped(KeyEvent e) {}

  public void resetGame() {
    currentPlayer = 0;
    roundNum = 0;
    turnsDone = 0;
    dealt = false;
    bets[0] = 10;
    bets[1] = 10;
    folded[0] = false;
    folded[1] = false;
    money[0] = 100;
    money[1] = 100;
    wins[0] = 0;
    wins[1] = 0;
    resultMsg = "";
    bonusMsg = "";
    game = new CardGame();
  }

  public void showButtons() {
    startBtn.setVisible(phase.equals("START") || phase.equals("ENDGAME"));
    betUpBtn.setVisible(phase.equals("BETTING"));
    betDownBtn.setVisible(phase.equals("BETTING"));
    dealBtn.setVisible(phase.equals("BETTING"));
    stayBtn.setVisible(phase.equals("CARDS"));
    foldBtn.setVisible(phase.equals("CARDS"));
    continueBtn.setVisible(phase.equals("TRANSITION"));
    nextBtn.setVisible(phase.equals("RESULT"));
    endBtn.setVisible(phase.equals("RESULT"));
  }
}
