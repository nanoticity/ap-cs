public class Triangle {
    private double base;
    private double height;

    public Triangle() {
        base = 0;
        height = 0;
    }

    public Triangle(double b, double h) {
        base = b;
        height = h;
    }

    public void printVariables() {
        System.out.println("base: " + base);
        System.out.println("height: " + height);
    }

    public void printArea() {
        System.out.println("triangle area: " + (0.5 * base * height));
    }
}
