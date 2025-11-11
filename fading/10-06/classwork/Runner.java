import java.util.Scanner;
public class Runner{
    public static void main(String[] args) {
        MathLibrary lib = new MathLibrary();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the radius. ");
        double r = s.nextDouble();
        System.out.println(lib.circumference(r));
        System.out.println(lib.areaCircle(r));
        System.out.println(lib.volSphere(r));
        System.out.println("Enter the height. ");
        double h = s.nextDouble();
        System.out.println(lib.volCylinder(r, h));
        System.out.println(lib.volCone(r, h));
    }
}
