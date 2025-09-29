public class One {
    private int length;
    private int width;

    public One() {
        length = 0;
        width = 0;
    }

    public One(int l, int w) {
        length = l;
        width = w;
    }

    public void printArea() {
        System.out.println("Area: " + (length * width));
    }

    public void printArea(int l, int w) {
        System.out.println("Area: " + (l * w));
    }
}
