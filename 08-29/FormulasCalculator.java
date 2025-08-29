import java.lang.Math;
import java.util.Scanner;
public class FormulasCalculator {

    public static void pythagorean() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pythagorean Theorem");
        double a, b, c;
        
        System.out.println("Enter a value for a");
        a = scan.nextDouble();
        
        System.out.println("Enter a value for b");
        b = scan.nextDouble();

        c = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("c = " + c);
    }

    public static void circle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Area of a circle");
        
        double radius, area;
        System.out.println("Enter the radius");
        radius = scan.nextDouble();

        area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle = " + area);
    }

    public static void rect() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Area of a rectangle");
        
        double base, height, areaRect;
        System.out.println("Enter the base");
        base = scan.nextDouble();
        
        System.out.println("Enter the height");
        height = scan.nextDouble();

        areaRect = base * height;
        System.out.println("Area of the Rectangle = " + areaRect);
    }

    public static void square() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Area of a square");
        System.out.println("Enter the side");
        double side = scan.nextDouble();
        double areaSquare = Math.pow(side, 2);
        System.out.println("Area of the square is = " + areaSquare);
    }

    public static void cone() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Volume of a cone");
        double radiusCone;
        double heightCone;

        System.out.println("Enter the radius");
        radiusCone = scan.nextDouble();

        System.out.println("Enter the height");
        heightCone = scan.nextDouble();

        double volume = (1.0 / 3.0) * Math.PI * Math.pow(radiusCone, 2) * heightCone;
        System.out.println("volume: " + volume);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which formula would you like to calculate?");
        System.out.println("1. Pythagorean Theorem");
        System.out.println("2. Area of a Circle");
        System.out.println("3. Area of a Rectangle");
        System.out.println("4. Area of a Square");
        System.out.println("5. Volume of a Cone");
        int choice = scan.nextInt();
        if (choice == 1) {
            pythagorean();
        } else if (choice == 2) {
            circle();
        } else if (choice == 3) {
            rect();
        } else if (choice == 4) {
            square();
        } else if (choice == 5) {
            cone();
        } else {
            System.out.println("Invalid choice");
        }
    }
}
