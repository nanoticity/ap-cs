import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Game {
    public int width = 800;
    public int height = 600;
    
    public Paddle paddle;
    public Ball ball;
    public Brick[] bricks;
    public Player player;
    
    public boolean gameStarted = false;
    public boolean ballOnPaddle = true;
    public int level = 1;
    
    public Game() {
        paddle = new Paddle(350, 550);
        ball = new Ball(390, 530);
        player = new Player();
        
        bricks = new Brick[50];
        int brickNumber = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                int brickX = 20 + col * 80;
                int brickY = 80 + row * 25;
                bricks[brickNumber] = new Brick(brickX, brickY);
                brickNumber = brickNumber + 1;
            }
        }
    }   
    
    public void update(boolean leftPressed, boolean rightPressed) {
        if (!gameStarted) {
            return;
        }
        
        if (leftPressed) {
            paddle.moveLeft();
        }
        if (rightPressed) {
            paddle.moveRight();
        }
        
        if (ballOnPaddle) {
            ball.x = paddle.x + paddle.width / 2 - ball.size / 2;
            ball.y = paddle.y - ball.size;
        } else {
            ball.move();
            checkCollisions();
        }
        
        if (ball.y > height) {
            player.lives = player.lives - 1;
            if (player.lives > 0) {
                ballOnPaddle = true;
                ball.speedX = 0;
                ball.speedY = 0;
            }
        }
    }

    private void playSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("pop.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
            
    }   

    public void checkCollisions() {
        if (ball.x <= 0 || ball.x + ball.size >= width) {
            ball.speedX = ball.speedX * -1;
        }
        
        if (ball.y <= 0) {
            ball.speedY = ball.speedY * -1;
        }
        
        if ((ball.getRect()).intersects(paddle.getRect())) {
            int baseSpeed = (level == 1) ? 5 : 7;
            
            int paddleCenter = paddle.x + paddle.width / 2;
            int ballCenter = ball.x + ball.size / 2;
            int offset = ballCenter - paddleCenter;
            
            double maxAngle = 60.0;
            double hitPercent = (double) offset / (paddle.width / 2);
            hitPercent = Math.max(-1.0, Math.min(1.0, hitPercent));
            
            double angle = hitPercent * Math.toRadians(maxAngle);
            
            ball.setXDir((int) (baseSpeed * Math.sin(angle)));
            ball.setYDir((int) (-baseSpeed * Math.cos(angle)));
        }
        
        for (int i = 0; i < bricks.length; i++) {
            if (!bricks[i].destroyed) {
                if (ball.x + ball.size >= bricks[i].x && 
                    ball.x <= bricks[i].x + bricks[i].width &&
                    ball.y + ball.size >= bricks[i].y && 
                    ball.y <= bricks[i].y + bricks[i].height) {
                    bricks[i].destroyed = true;
                    player.score = player.score + 10;

                    playSound();
                    
                    int ballCenterX = ball.x + ball.size / 2;
                    int ballCenterY = ball.y + ball.size / 2;
                    int brickCenterX = bricks[i].x + bricks[i].width / 2;
                    int brickCenterY = bricks[i].y + bricks[i].height / 2;
                    
                    int deltaX = Math.abs(ballCenterX - brickCenterX);
                    int deltaY = Math.abs(ballCenterY - brickCenterY);
                    
                    double widthRatio = (double) deltaX / (bricks[i].width / 2);
                    double heightRatio = (double) deltaY / (bricks[i].height / 2);
                    
                    if (widthRatio > heightRatio) {
                        ball.speedX = ball.speedX * -1;
                    } else {
                        ball.speedY = ball.speedY * -1;
                    }
                }
            }
        }
    }
    
    public void launchBall(boolean leftPressed, boolean rightPressed) {
        if (ballOnPaddle) {
            ballOnPaddle = false;
            int speed = (level == 1) ? 3 : 5;
            
            if (leftPressed) {
                ball.speedX = -speed;
            } else if (rightPressed) {
                ball.speedX = speed;
            } else {
                ball.speedX = 0;
            }
            ball.speedY = (level == 1) ? -5 : -7;
        }
    }
    
    public void restart() {
        player.lives = 3;
        player.score = 0;
        ballOnPaddle = true;
        level = 1;
        
        ball.x = 390;
        ball.y = 530;
        ball.speedX = 0;
        ball.speedY = 0;
        
        for (int i = 0; i < bricks.length; i++) {
            bricks[i].destroyed = false;
        }
    }
    
    public void nextLevel() {
        level = 2;
        ballOnPaddle = true;
        
        ball.x = 390;
        ball.y = 530;
        ball.speedX = 0;
        ball.speedY = 0;
        
        for (int i = 0; i < bricks.length; i++) {
            bricks[i].destroyed = false;
        }
    }
    
    public boolean allBricksDestroyed() {
        for (int i = 0; i < bricks.length; i++) {
            if (!bricks[i].destroyed) {
                return false;
            }
        }
        return true;
    }
}
