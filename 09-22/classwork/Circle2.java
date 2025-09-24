public class Circle2 {
    private double pi;
    private double radius;

    public Circle2(double radius) {
        this.radius = radius;
        this.pi = 3.14;
    }

    public Circle2() {
        this.radius = 1.0;
        this.pi = 3.14;
    }

    public void printArea() {
        double area = pi * radius * radius;
        System.out.println("Area of the circle: " + area);
    }
    public void printVol(double r){
        double vol = Math.pow(r, 3)* (4.0/3.0) * pi;
        System.out.println("The area of the sphere is " + vol);
    }

    public void printArea(double r) {
        double area = pi * r * r;
        System.out.println("Area of the circle with radius " + r + ": " + area);
    }

    public void printVol(double r, double h) {
        double volume = Math.pow(r, 2) * h * pi;
        System.out.println("Volume of the cylinder with radius " + r + " and height " + h + ": " + volume);
    }


}