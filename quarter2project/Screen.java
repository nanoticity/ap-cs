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
        for (int i = 0; i < 400; i++) {
            int blue = 200 + (i / 8);
            g.setColor(new Color(135, 206, Math.min(blue, 255)));
            g.drawLine(0, i, 800, i);
        }
        
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, 400, 800, 200);
        
        g.setColor(new Color(46, 125, 50));
        for (int y = 410; y < 600; y += 15) {
            for (int x = 0; x < 800; x += 8) {
                int offset = (x % 16 == 0) ? 5 : 0;
                g.drawLine(x, y + offset, x, y + offset + 8);
            }
        }
        
        g.setColor(new Color(56, 142, 60));
        for (int y = 415; y < 600; y += 12) {
            for (int x = 4; x < 800; x += 10) {
                g.drawLine(x, y, x, y + 6);
            }
        }
        
        g.setColor(new Color(27, 94, 32));
        for (int y = 420; y < 600; y += 18) {
            for (int x = 2; x < 800; x += 12) {
                g.drawLine(x, y, x, y + 4);
            }
        }
        
        g.setColor(new Color(255, 255, 100));
        g.fillOval(650, 50, 80, 80);
        g.setColor(new Color(255, 255, 150, 100));
        g.fillOval(640, 40, 100, 100);
    }
    
    public void drawLavaBackground(Graphics g) {
        for (int i = 0; i < 600; i++) {
            int red = 80 + (i / 4);
            int green = 10 + (i / 15);
            g.setColor(new Color(Math.min(red, 255), green, 0));
            g.drawLine(0, i, 800, i);
        }
        
        g.setColor(new Color(255, 69, 0, 150));
        g.fillOval(80, 430, 70, 35);
        g.fillOval(220, 460, 90, 45);
        g.fillOval(450, 445, 75, 38);
        g.fillOval(620, 470, 85, 40);
        
        g.setColor(new Color(255, 140, 0, 120));
        g.fillOval(150, 480, 60, 30);
        g.fillOval(350, 490, 80, 35);
        g.fillOval(550, 475, 65, 32);
        g.fillOval(700, 455, 70, 35);
        
        g.setColor(new Color(255, 200, 0, 80));
        for (int x = 50; x < 750; x += 120) {
            g.fillOval(x, 500, 40, 20);
        }
        
        g.setColor(new Color(139, 69, 19));
        int[] xRock1 = {60, 90, 130, 120, 50};
        int[] yRock1 = {540, 520, 530, 560, 555};
        g.fillPolygon(xRock1, yRock1, 5);
        
        int[] xRock2 = {380, 420, 450, 440, 370};
        int[] yRock2 = {545, 530, 540, 570, 565};
        g.fillPolygon(xRock2, yRock2, 5);
        
        int[] xRock3 = {680, 720, 750, 740, 670};
        int[] yRock3 = {525, 510, 520, 555, 550};
        g.fillPolygon(xRock3, yRock3, 5);
        
        g.setColor(new Color(101, 67, 33));
        g.fillOval(70, 545, 20, 15);
        g.fillOval(390, 550, 25, 18);
        g.fillOval(690, 530, 22, 16);
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
        
        if (key == KeyEvent.VK_9) {
            if (game.level == 1) {
                game.nextLevel();
            } else {
                game.player.lives = 0;
            }
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
