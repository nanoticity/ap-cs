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
}
