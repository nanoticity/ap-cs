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
  int[] pairPlusBets;
  boolean[] folded;
  int[] money;
  boolean dealt;
  int turnsDone;
  String resultMsg;
  int[] wins;
  String bonusMsg;
  String ppMsg;

  JButton startBtn;
  JButton betUpBtn;
  JButton betDownBtn;
  JButton ppUpBtn;
  JButton ppDownBtn;
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
    pairPlusBets = new int[2];
    pairPlusBets[0] = 0;
    pairPlusBets[1] = 0;
    folded = new boolean[2];
    money = new int[2];
    money[0] = 100;
    money[1] = 100;
    wins = new int[2];
    resultMsg = "";
    bonusMsg = "";
    ppMsg = "";

    startBtn   = makeBtn("START GAME",  375, 460, 250, 48);
    betUpBtn   = makeBtn("+ $5",        660, 230, 80,  42);
    betDownBtn = makeBtn("- $5",        260, 230, 80,  42);
    ppUpBtn    = makeBtn("+ $5",        660, 310, 80,  42);
    ppDownBtn  = makeBtn("- $5",        260, 310, 80,  42);
    dealBtn    = makeBtn("DEAL CARDS",  375, 400, 250, 48);
    stayBtn    = makeBtn("STAY IN",     230, 460, 210, 48);
    foldBtn    = makeBtn("FOLD",        560, 460, 210, 48);
    continueBtn = makeBtn("CONTINUE",  375, 460, 250, 48);
    nextBtn    = makeBtn("NEXT ROUND",  275, 460, 200, 48);
    endBtn     = makeBtn("END GAME",    525, 460, 200, 48);

    add(startBtn);
    add(betUpBtn);
    add(betDownBtn);
    add(ppUpBtn);
    add(ppDownBtn);
    add(dealBtn);
    add(stayBtn);
    add(foldBtn);
    add(continueBtn);
    add(nextBtn);
    add(endBtn);

    startBtn.addActionListener(this);
    betUpBtn.addActionListener(this);
    betDownBtn.addActionListener(this);
    ppUpBtn.addActionListener(this);
    ppDownBtn.addActionListener(this);
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
      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 48));
      g.drawString("PLAYER " + (currentPlayer + 1), 60, 85);

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 24));
      g.drawString("Round " + (roundNum + 1), 60, 135);
      g.drawString("Balance: $" + money[currentPlayer], 60, 175);

      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 22));
      g.drawString("Ante Bet:", 420, 214);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.BOLD, 34));
      g.drawString("$" + bets[currentPlayer], 470, 255);

      g.setColor(new Color(100, 255, 100));
      g.setFont(new Font("Arial", Font.BOLD, 22));
      g.drawString("Pair Plus (optional):", 330, 298);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.BOLD, 34));
      g.drawString("$" + pairPlusBets[currentPlayer], 470, 335);

      g.setFont(new Font("Arial", Font.PLAIN, 15));
      g.setColor(new Color(180, 230, 180));
      g.drawString("Pair Plus pays out regardless of dealer's hand (Pair=1x, Flush=4x, Straight=6x, Trips=30x, SF=40x)", 60, 385);

    } else if (phase.equals("CARDS")) {
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

      if (handType >= 1) {
        int bonus = game.getBonus(handType) * bets[currentPlayer];
        g.setColor(new Color(100, 255, 100));
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Bonus payout: +$" + bonus, 600, 125);
      }

      game.drawHand(g, hand, 500, 145);

      g.setColor(new Color(180, 230, 180));
      g.setFont(new Font("Arial", Font.PLAIN, 16));
      g.drawString("Choose STAY IN or FOLD.", 395, 410);

    } else if (phase.equals("TRANSITION")) {
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.BOLD, 42));
      g.drawString("PASS THE SCREEN", 265, 215);
      g.setFont(new Font("Arial", Font.PLAIN, 24));
      g.drawString("Player " + (currentPlayer + 1) + ", press CONTINUE when ready.", 255, 275);

    } else if (phase.equals("RESULT")) {
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

      if (ppMsg.length() > 0) {
        g.setColor(new Color(100, 220, 255));
        g.setFont(new Font("Arial", Font.BOLD, 18));
        int pw = g.getFontMetrics().stringWidth(ppMsg);
        g.drawString(ppMsg, (1000 - pw) / 2, 315);
      }

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 20));
      g.drawString("Player 1 Balance: $" + money[0], 350, 355);
      g.drawString("Player 2 Balance: $" + money[1], 350, 390);

    } else if (phase.equals("ENDGAME")) {
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

      String winner = "IT'S A TIE!";
      if (money[0] > money[1])
        winner = "PLAYER 1 WINS!";
      else if (money[1] > money[0])
        winner = "PLAYER 2 WINS!";

      g.setColor(new Color(255, 215, 0));
      g.setFont(new Font("Arial", Font.BOLD, 40));
      int tw = g.getFontMetrics().stringWidth(winner);
      g.drawString(winner, (1000 - tw) / 2, 400);


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

    ppMsg = "";
    if (pairPlusBets[0] > 0) {
      int pp1Mult = game.getPairPlusBonus(game.evaluate(game.hand1)[0]);
      if (pp1Mult > 0) {
        int pp1Win = pairPlusBets[0] * pp1Mult;
        money[0] += pp1Win;
        ppMsg += "P1 Pair Plus +$" + pp1Win;
      } else {
        money[0] -= pairPlusBets[0];
        ppMsg += "P1 Pair Plus -$" + pairPlusBets[0];
      }
    }
    if (pairPlusBets[1] > 0) {
      int pp2Mult = game.getPairPlusBonus(game.evaluate(game.hand2)[0]);
      if (ppMsg.length() > 0) ppMsg += "   ";
      if (pp2Mult > 0) {
        int pp2Win = pairPlusBets[1] * pp2Mult;
        money[1] += pp2Win;
        ppMsg += "P2 Pair Plus +$" + pp2Win;
      } else {
        money[1] -= pairPlusBets[1];
        ppMsg += "P2 Pair Plus -$" + pairPlusBets[1];
      }
    }

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

    if (money[0] <= 0)
      resultMsg += "  |  Player 1 is out of money!";
    else if (money[1] <= 0)
      resultMsg += "  |  Player 2 is out of money!";
  }

  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();

    if (src == startBtn) {
      resetGame();
      phase = "BETTING";
    }

    if (src == betUpBtn) {
      if (bets[currentPlayer] + 5 + pairPlusBets[currentPlayer] <= money[currentPlayer])
        bets[currentPlayer] += 5;
    }

    if (src == betDownBtn) {
      if (bets[currentPlayer] > 5)
        bets[currentPlayer] -= 5;
    }

    if (src == ppUpBtn) {
      if (bets[currentPlayer] + pairPlusBets[currentPlayer] + 5 <= money[currentPlayer])
        pairPlusBets[currentPlayer] += 5;
    }

    if (src == ppDownBtn) {
      if (pairPlusBets[currentPlayer] >= 5)
        pairPlusBets[currentPlayer] -= 5;
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
      pairPlusBets[currentPlayer] = 0;
      phase = "BETTING";
    }

    if (src == nextBtn) {
      if (money[0] <= 0 || money[1] <= 0) {
        phase = "ENDGAME";
      } else {
        currentPlayer = 0;
        dealt = false;
        turnsDone = 0;
        bets[0] = Math.min(10, money[0]);
        bets[1] = Math.min(10, money[1]);
        pairPlusBets[0] = 0;
        pairPlusBets[1] = 0;
        folded[0] = false;
        folded[1] = false;
        phase = "BETTING";
      }
    }

    if (src == endBtn) {
      phase = "ENDGAME";
    }

    showButtons();
    repaint();
    requestFocusInWindow();
  }

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
    pairPlusBets[0] = 0;
    pairPlusBets[1] = 0;
    folded[0] = false;
    folded[1] = false;
    money[0] = 100;
    money[1] = 100;
    wins[0] = 0;
    wins[1] = 0;
    resultMsg = "";
    bonusMsg = "";
    ppMsg = "";
    game = new CardGame();
  }

  public void showButtons() {
    startBtn.setVisible(phase.equals("START") || phase.equals("ENDGAME"));
    betUpBtn.setVisible(phase.equals("BETTING"));
    betDownBtn.setVisible(phase.equals("BETTING"));
    ppUpBtn.setVisible(phase.equals("BETTING"));
    ppDownBtn.setVisible(phase.equals("BETTING"));
    dealBtn.setVisible(phase.equals("BETTING"));
    stayBtn.setVisible(phase.equals("CARDS"));
    foldBtn.setVisible(phase.equals("CARDS"));
    continueBtn.setVisible(phase.equals("TRANSITION"));
    nextBtn.setVisible(phase.equals("RESULT"));
    endBtn.setVisible(phase.equals("RESULT"));
  }
}
