import java.awt.Rectangle;

public class Ball {
    public int x;
    public int y;
    public int size;
    public int speedX;
    public int speedY;
    
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = 15;
        this.speedX = 0;
        this.speedY = 0;
    }
    
    public void move() {
        x = x + speedX;
        y = y + speedY;
    }
    
    public Rectangle getRect() {
        return new Rectangle(x, y, size, size);
    }
    
    public int getYDir() {
        return speedY > 0 ? 1 : -1;
    }
    
    public void setXDir(int dir) {
        speedX = dir;
    }
    
    public void setYDir(int dir) {
        speedY = dir;
    }
}
