import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Table extends JPanel implements ActionListener {

  private JButton hitButton;
  private JButton standButton;
  private JButton playAgainButton;
  private Blackjack game;
  
  private boolean animating;
  private int animationFrame;
  private Timer animationTimer;

  public Table() {
    setLayout(null);
    game = new Blackjack();

    hitButton = new JButton("Hit");
    hitButton.setBounds(50, 500, 100, 40);
    add(hitButton);
    hitButton.addActionListener(this);

    standButton = new JButton("Stand");
    standButton.setBounds(170, 500, 100, 40);
    add(standButton);
    standButton.addActionListener(this);

    playAgainButton = new JButton("Play Again");
    playAgainButton.setBounds(290, 500, 120, 40);
    add(playAgainButton);
    playAgainButton.addActionListener(this);
    
    animating = false;
    animationFrame = 0;
    animationTimer = new Timer(50, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        animationFrame++;
        if (animationFrame > 60) {
          animating = false;
          animationFrame = 0;
          animationTimer.stop();
        }
        repaint();
      }
    });
  }

  public Dimension getPreferredSize() {
    return new Dimension(1000, 600);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    game.drawGame(g);
    
    if (animating && game.isGameOver()) {
      drawWinAnimation(g);
    }
  }

  private void drawWinAnimation(Graphics g) {
    int alpha = (int)(Math.sin(animationFrame * 0.2) * 127 + 128);
    Color flashColor = new Color(255, 215, 0, Math.min(alpha, 255));
    
    for (int i = 0; i < 5; i++) {
      int radius = 50 + animationFrame * 3 + i * 30;
      g.setColor(new Color(255, 215, 0, Math.max(0, 100 - animationFrame * 2)));
      g.drawOval(500 - radius, 300 - radius, radius * 2, radius * 2);
    }
    
    int numStars = 20;
    for (int i = 0; i < numStars; i++) {
      double angle = (animationFrame * 0.1 + i * (2 * Math.PI / numStars));
      int x = (int)(500 + Math.cos(angle) * (50 + animationFrame * 2));
      int y = (int)(300 + Math.sin(angle) * (50 + animationFrame * 2));
      int starSize = 10 + (int)(Math.sin(animationFrame * 0.3 + i) * 5);
      
      g.setColor(new Color(255, 255, 0, Math.max(0, 255 - animationFrame * 4)));
      g.fillOval(x - starSize/2, y - starSize/2, starSize, starSize);
    }
    
    g.setColor(flashColor);
    g.fillRect(0, 0, 1000, 10);
    g.fillRect(0, 590, 1000, 10);
    g.fillRect(0, 0, 10, 600);
    g.fillRect(990, 0, 10, 600);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == hitButton) {
      game.hit();
    } else if (e.getSource() == standButton) {
      game.stand();
      if (game.isGameOver() && game.getHandValue() >= 16 && game.getHandValue() <= 21) {
        animating = true;
        animationFrame = 0;
        animationTimer.start();
      }
    } else if (e.getSource() == playAgainButton) {
      if (game.canPlayAgain()) {
        game.startNewGame();
        animating = false;
        animationFrame = 0;
        animationTimer.stop();
      }
    }

    repaint();
  }
}
