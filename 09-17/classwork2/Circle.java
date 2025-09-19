public class Circle {
    private double radius;
    private double pi;

    public Circle(double r) {
        radius = r;
        pi = 3.14;
    }

    public Circle() {
        radius = 0;
        pi = 3.14;
    }

    public void printVariables() {
        System.out.println("radius: " + radius);
        System.out.println("pi: " + pi);
    }

    public void printArea() {
        System.out.println("circle area: " + (pi * radius * radius));
    }

}
