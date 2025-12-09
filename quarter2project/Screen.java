import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen extends JPanel implements KeyListener {
    public Game game;
    public boolean leftPressed = false;
    public boolean rightPressed = false;
    public Timer timer;
    
    public Screen() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        
        game = new Game();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    
    public void animate() {
        if (timer == null) {
            timer = new Timer(16, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.update(leftPressed, rightPressed);
                    repaint();
                }
            });
            timer.start();
        }
        game.update(leftPressed, rightPressed);
        repaint();
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (!game.gameStarted) {
            drawMenu(g);
        } else if (game.player.lives <= 0) {
            drawGameOver(g);
        } else if (game.allBricksDestroyed()) {
            if (game.level == 1) {
                drawLevelComplete(g);
            } else {
                drawWinScreen(g);
            }
        } else {
            drawGame(g);
        }
    }
    
    public void drawMenu(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("BREAKOUT", 280, 150);
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("INSTRUCTIONS:", 300, 250);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Use LEFT and RIGHT arrow keys to move", 230, 290);
        g.drawString("Press SPACE to launch the ball", 260, 320);
        g.drawString("Move paddle when launching to aim the ball", 210, 350);
        g.drawString("Break all the bricks!", 310, 380);
        g.drawString("You have 3 lives", 320, 410);
        
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("CREDITS:", 350, 470);
        g.drawString("Created by: Ari", 330, 490);
        g.drawString("AP Computer Science Project", 290, 510);
        
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Press ENTER to Start", 280, 560);
    }
    
    public void drawGame(Graphics g) {
        if (game.level == 1) {
            drawMeadowBackground(g);
        } else {
            drawLavaBackground(g);
        }
        
        g.setColor(Color.WHITE);
        g.fillRect(game.paddle.x, game.paddle.y, game.paddle.width, game.paddle.height);
        
        g.setColor(Color.WHITE);
        g.fillOval(game.ball.x, game.ball.y, game.ball.size, game.ball.size);
        
        g.setColor(Color.WHITE);
        for (int i = 0; i < game.bricks.length; i++) {
            if (!game.bricks[i].destroyed) {
                g.fillRect(game.bricks[i].x, game.bricks[i].y, game.bricks[i].width, game.bricks[i].height);
            }
        }
        
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Lives: " + game.player.lives, 20, 30);
        g.drawString("Score: " + game.player.score, 680, 30);
        g.drawString("Level: " + game.level, 360, 30);
    }
    
    public void drawGameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("GAME OVER", 250, 250);
        
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Final Score: " + game.player.score, 300, 320);
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Press R to Restart", 300, 380);
    }
    
    public void drawLevelComplete(Graphics g) {
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("LEVEL 1 COMPLETE!", 160, 250);
        
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Score: " + game.player.score, 320, 320);
        g.drawString("Get ready for Level 2!", 260, 360);
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Press ENTER to Continue", 270, 420);
    }
    
    public void drawWinScreen(Graphics g) {
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("YOU WIN!", 280, 200);
        
        g.setFont(new Font("Arial", Font.PLAIN, 36));
        g.drawString("Congratulations!", 250, 270);
        
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Final Score: " + game.player.score, 300, 340);
        g.drawString("You beat both levels!", 270, 380);
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Press R to Play Again", 290, 450);
    }
    
    public void drawMeadowBackground(Graphics g) {
        // Sky gradient - peaceful blue
        for (int i = 0; i < 400; i++) {
            int blue = 200 + (i / 8);
            g.setColor(new Color(135, 206, Math.min(blue, 255)));
            g.drawLine(0, i, 800, i);
        }
        
        g.setColor(new Color(50, 150, 50));
        g.fillRect(0, 400, 800, 200);
        
        g.setColor(new Color(70, 170, 70));
        for (int i = 0; i < 800; i += 60) {
            g.fillOval(i, 420, 50, 20);
        }
        
        g.setColor(new Color(255, 255, 100));
        g.fillOval(650, 50, 80, 80);
    }
    
    public void drawLavaBackground(Graphics g) {
        for (int i = 0; i < 600; i++) {
            int red = 150 + (i / 6);
            int green = 30 + (i / 20);
            g.setColor(new Color(Math.min(red, 255), green, 0));
            g.drawLine(0, i, 800, i);
        }
        
        g.setColor(new Color(255, 100, 0, 100));
        g.fillOval(100, 450, 60, 60);
        g.fillOval(300, 480, 50, 50);
        g.fillOval(500, 470, 55, 55);
        g.fillOval(650, 460, 45, 45);
        
        g.setColor(new Color(60, 30, 20));
        g.fillRect(50, 520, 80, 40);
        g.fillRect(400, 530, 60, 35);
        g.fillRect(700, 510, 70, 50);
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_ENTER && !game.gameStarted) {
            game.gameStarted = true;
        }
        
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        
        if (key == KeyEvent.VK_SPACE) {
            game.launchBall(leftPressed, rightPressed);
        }
        
        if (key == KeyEvent.VK_R && (game.player.lives <= 0 || game.allBricksDestroyed())) {
            game.restart();
        }
        
        if (key == KeyEvent.VK_ENTER && game.allBricksDestroyed() && game.level == 1) {
            game.nextLevel();
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
    
    public void keyTyped(KeyEvent e) { }
}
