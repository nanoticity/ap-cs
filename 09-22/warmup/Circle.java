public class Circle {
    private double pi;
    private double radius;

    public Circle(double r) {
        pi = 3.14;
        radius = r;
    }

    public Circle() {
        pi = 3.14;
        radius = 0;
    }

    public void printCylinderVolume(double height) {
        double volume = pi * radius * radius * height;
        System.out.println("The volume of the cylinder is " + volume);
    }
}
