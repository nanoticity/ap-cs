public class Cone {
    public static void main(String[] args) {
        double radius, height, PI, volume;
        radius = 3.0;
        height = 6.0;
        PI = 3.14;

        System.out.println("Cone Volume Calculator");
        volume = (1.0/3.0) * PI * Math.pow(radius, 2) * height;
        System.out.println("The volume of the cone is: " + volume);
    }
}