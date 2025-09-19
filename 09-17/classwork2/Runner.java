import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Select a shape to calculate area: ");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Triangle");
        System.out.println("4. Circle");

        int choice = scan.nextInt();

        if (choice == 1) {
            System.out.print("Enter length: ");
            double length = scan.nextDouble();
            System.out.print("Enter width: ");
            double width = scan.nextDouble();
            Rectangle rect = new Rectangle(length, width);
            rect.printArea();
        } else if (choice == 2) {
            System.out.print("Enter side length: ");
            double side = scan.nextDouble();
            Square square = new Square(side);
            square.printArea();
        } else if (choice == 3) {
            System.out.print("Enter base: ");
            double base = scan.nextDouble();
            System.out.print("Enter height: ");
            double height = scan.nextDouble();
            Triangle tri = new Triangle(base, height);
            tri.printArea();
        } else if (choice == 4) {
            System.out.print("Enter radius: ");
            double radius = scan.nextDouble();
            Circle circ = new Circle(radius);
            circ.printArea();
        } else {
            System.out.println("Invalid choice.");
        }

    }
}
