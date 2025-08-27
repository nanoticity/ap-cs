public class Cylinder {
    public static void main(String[] args) {
        double volume, radius, height, pi;
        pi = 3.14;
        radius = 6;
        height = 10;

        System.out.println("Cylinder Area Solver");

        System.out.println("Pi: " + pi);
        System.out.println("Radius: " + radius);
        System.out.println("Height: " + height);

        volume = pi * radius * radius * height;
        System.out.println("Volme: " + volume);
    }
}
