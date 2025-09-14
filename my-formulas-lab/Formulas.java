import java.util.Scanner;
import java.lang.Math;

public class Formulas {
    
    private Scanner scan = new Scanner(System.in);
    private double PI = 3.14;

    public int displayMenu() {
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
        System.out.println("0. Quit");
        System.out.println("1. Area of a rectangle");
        System.out.println("2. Area of a circle");
        System.out.println("3. Area of a parallelogram");
        System.out.println("4. Area of an ellipse");
        System.out.println("5. Distance formula");
        System.out.println("6. Slope between two points");
        System.out.println("7. Simple interest");
        System.out.println("8. Perimeter of a rectangle");
        System.out.println("9. Volume of a rectangular prism");
        System.out.println("10. Volume of a cylinder");
        System.out.println("11. Volume of a cone");
        System.out.println("12. Area of a trapezoid");
        System.out.println("13. Geometric mean");
        System.out.println("14. Harmonic mean");
        System.out.println("15. GCD");

        int choice = scan.nextInt();
        return choice;
    }

    // Area of a rectangle
    public void areaOfRect() {
        System.out.println("\n1. Area of a rectangle");
        System.out.println("\nEnter the length of the rectangle:");
        double length = scan.nextDouble();
        System.out.println("\nEnter the width of the rectangle:");
        double width = scan.nextDouble();
        double area = length * width;
        System.out.println("\n\nThe area of the rectangle is " + area);

    }

    // Area of a circle
    public void areaOfCircle() {
        System.out.println("\n2. Area of a circle");
        System.out.println("\nEnter the radius of the circle:");
        double radius = scan.nextDouble();
        double area = Math.pow(radius, 2) * PI;
        System.out.println("\n\nThe area of the circle is " + area);

    }

    // Area of a Parallelogram
    public void areaOfParallelogram() {
        System.out.println("\n3. Area of a parallelogram");
        System.out.println("\nEnter the length of the parallelogram:");
        double length = scan.nextDouble();
        System.out.println("\nEnter the width of the parallelogram:");
        double width = scan.nextDouble();
        double area = length * width;
        System.out.println("\n\nThe area of the parallelogram is " + area);

    }

    // Area of an ellipse
    public void areaOfEllipse() {
        System.out.println("\n4. Area of a ellipse");
        System.out.println("\nEnter the length of the semi-major axis:");
        double semiMajorAxis = scan.nextDouble();
        System.out.println("\nEnter the length of the semi-minor axis:");
        double semiMinorAxis = scan.nextDouble();
        double area = PI * semiMajorAxis * semiMinorAxis;
        System.out.println("\n\nThe area of the ellipse is " + area);
    
    }

    // Distance formula
    public void distanceFormula() {
        System.out.println("\n5. Distance formula");
        System.out.println("\nEnter the x-coordinate of the first point:");
        double x1 = scan.nextDouble();
        System.out.println("\nEnter the y-coordinate of the first point:");
        double y1 = scan.nextDouble();
        System.out.println("\nEnter the x-coordinate of the second point:");
        double x2 = scan.nextDouble();
        System.out.println("\nEnter the y-coordinate of the second point:");
        double y2 = scan.nextDouble();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("\n\nThe distance between the two points is " + distance);
    
    }

    // Slope formula
    public void slopeFormula() {
        System.out.println("\n6. Slope of a line");
        System.out.println("\nEnter the x-coordinate of the first point:");
        double x1 = scan.nextDouble();
        System.out.println("\nEnter the y-coordinate of the first point:");
        double y1 = scan.nextDouble();
        System.out.println("\nEnter the x-coordinate of the second point:");
        double x2 = scan.nextDouble();
        System.out.println("\nEnter the y-coordinate of the second point:");
        double y2 = scan.nextDouble();
        double slope = (y2 - y1) / (x2 - x1);
        System.out.println("\n\nThe slope between the two points is " + slope);
    }

    // Simple interest
    public void simpleInterest() {
        System.out.println("\n7. Simple interest");
        System.out.println("\nEnter the principal value:");
        double principal = scan.nextDouble();
        System.out.println("\nEnter the interest rate:");
        double rate = scan.nextDouble();
        double interest = rate * principal;
        System.out.println("\n\nThe interest is " + interest);
    }

    // Perimiter of a rectangle
    public void permieterOfRect() {
        System.out.println("\n8. Permiter of a rectangle");
        System.out.println("\nEnter the length of the rectangle:");
        double length = scan.nextDouble();
        System.out.println("\nEnter the width of the rectangle:");
        double width = scan.nextDouble();
        double perimeter = 2 * (width + length);
        System.out.println("\n\nThe perimeter of ther rectangle is " + perimeter);
    }

    // Volume of a rectangular prism
    public void volumeOfRectPrism() {
        System.out.println("\n9. Volume of arectangular prism");
        System.out.println("\nEnter the length of the rectanglular prism:");
        double length = scan.nextDouble();
        System.out.println("\nEnter the width of the rectangular prism:");
        double width = scan.nextDouble();
        System.out.println("\nEnter the height of the rectangular prism:");
        double height = scan.nextDouble();
        double volume = width * length * height;
        System.out.println("\n\nThe volme of ther rectangular prism is " + volume);
    }
    
    // Volume of a cylinder
    public void volumeOfCylinder() {
        System.out.println("\n10. Volume of a cylinder");
        System.out.println("\nEnter the radius of the base:");
        double radius = scan.nextDouble();
        System.out.println("\nEnter the height of the cylinder:");
        double height = scan.nextDouble();
        double volume = PI * Math.pow(radius, 2) * height;
        System.out.println("\n\nThe volume of the cylinder is " + volume);
    }

    // Volume of a cone
    public void volumeOfCone() {
        System.out.println("\n11. Volume of a cone");
        System.out.println("\nEnter the radius of the base:");
        double radius = scan.nextDouble();
        System.out.println("\nEnter the height of the cone:");
        double height = scan.nextDouble();
        double volume = (1.0/3) * PI * Math.pow(radius, 2) * height;
        System.out.println("\n\nThe volume of the cone is " + volume);
    }

    // Area of trapezoid
    public void areaOfTrapezoid() {
        System.out.println("\n12. Area of a trapezoid");
        System.out.println("\nEnter the first base of the trapezoid:");
        double base1 = scan.nextDouble();
        System.out.println("\nEnter the second base of the trapezoid:");
        double base2 = scan.nextDouble();
        System.out.println("\nEnter the height of the trapezoid:");
        double height = scan.nextDouble();
        double area = ((base1 + base2) / 2) * height;
        System.out.println("\n\nThe area of the trapezoid is " + area);
    }

    // Geometric mean
    public void geometricMean() {
        System.out.println("\n13. Geometric mean");
        System.out.println("\nEnter the first number:");
        double a = scan.nextDouble();
        System.out.println("\nEnter the second number:");
        double b = scan.nextDouble();
        double geometricMean = Math.sqrt(a * b);
        System.out.println("\n\nThe geometric mean is " + geometricMean);
    }

    // Harmonic mean
    public void harmonicMean() {
        System.out.println("\n14. Harmonic mean");
        System.out.println("\nEnter the first number:");
        double a = scan.nextDouble();
        System.out.println("\nEnter the second number:");
        double b = scan.nextDouble();
        double harmonicMean = 2 * a * b / (a + b);
        System.out.println("\n\nThe harmonic mean is " + harmonicMean);
    }

    // Helper function for GCD
    // If this looks suspicious, I already coded this once in python
    // for my coding 3 class in middle school, and just adapted it to java for this class.

    private double GCDRecursive(double a, double b) {
        if (b == 0.0) {
            return a;
        }
        return GCDRecursive(b, a % b);
    }

    // GCD
    public void GCD() {
        System.out.println("\n13. Greatest common divisor");
        System.out.println("\nEnter the first number:");
        double a = scan.nextDouble();
        System.out.println("\nEnter the second number:");
        double b = scan.nextDouble();
        double gcd = GCDRecursive(a, b);
        System.out.println("\n\nThe greatest common divisor is " + gcd);
    }

}