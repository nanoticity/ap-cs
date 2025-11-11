public class Circle {
    private double pi; 

    public Circle() {
        pi = 3.14;
    } 

    private double area(double radius) {
        return pi * radius * radius;
    }

    public double volCyl(double radius, double height) {
        return area(radius) * height;
    }
}