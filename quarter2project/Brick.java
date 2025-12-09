public class Brick {
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean destroyed;
    
    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 75;
        this.height = 20;
        this.destroyed = false;
    }
}
