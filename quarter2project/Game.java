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
    
    public void checkCollisions() {
        if (ball.x <= 0 || ball.x + ball.size >= width) {
            ball.speedX = ball.speedX * -1;
        }
        
        if (ball.y <= 0) {
            ball.speedY = ball.speedY * -1;
        }
        
        if (ball.x + ball.size >= paddle.x && 
            ball.x <= paddle.x + paddle.width &&
            ball.y + ball.size >= paddle.y && 
            ball.y <= paddle.y + paddle.height) {
            ball.speedY = (level == 1) ? -5 : -7;
            
            int ballCenter = ball.x + ball.size / 2;
            int paddleCenter = paddle.x + paddle.width / 2;
            int hitPosition = ballCenter - paddleCenter;
            
            ball.speedX = hitPosition / 8;
        }
        
        for (int i = 0; i < bricks.length; i++) {
            if (!bricks[i].destroyed) {
                if (ball.x + ball.size >= bricks[i].x && 
                    ball.x <= bricks[i].x + bricks[i].width &&
                    ball.y + ball.size >= bricks[i].y && 
                    ball.y <= bricks[i].y + bricks[i].height) {
                    bricks[i].destroyed = true;
                    ball.speedY = ball.speedY * -1;
                    player.score = player.score + 10;
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
