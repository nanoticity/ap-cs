public class Radius {
    double pi = 3.14;

    public void printArea(double radius) {
        double area = pi * radius * radius;
        System.out.println("The area of a circle with radius " + radius + " is " + area);
    }

    public void printCir(double radius) {
        double circumference = 2 * pi * radius;
        System.out.println("The circumference of a circle with radius " + radius + " is " + circumference);
    }

    public void printConeVol(double radius, double height) {
        double volume = (1.0/3) * pi * radius * radius * height;
        System.out.println("The volume of a cone with radius " + radius + " and height " + height + " is " + volume);
    }
}
