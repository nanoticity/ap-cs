import java.lang.Math;
import java.util.Scanner;

public class MathSolver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            
        System.out.println("Pythagorean Theirem Solver");
        double a, b, c;
        
        System.out.println("Enter a value for a");
        a = scan.nextDouble();
        
        System.out.println("Enter a value for b");
        b = scan.nextDouble();

        c = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("c = " + c);

        System.out.println("Area of a circle solver");
        
        double radius, area;
        System.out.println("Enter the radius");
        radius = scan.nextDouble();

        area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle = " + area);

        System.out.println("Area of a rectangle solver");
        
        double base, height, areaRect;
        System.out.println("Enter the base");
        base = scan.nextDouble();
        
        System.out.println("Enter the height");
        height = scan.nextDouble();

        areaRect = base * height;
        System.out.println("Area of the Rectangle = " + areaRect);

    }
}
