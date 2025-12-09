public class Paddle {
    public int x;
    public int y;
    public int width;
    public int height;
    
    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 15;
    }
    
    public void moveLeft() {
        if (x > 0) {
            x = x - 7;
        }
    }
    
    public void moveRight() {
        if (x < 800 - width) {
            x = x + 7;
        }
    }
}
