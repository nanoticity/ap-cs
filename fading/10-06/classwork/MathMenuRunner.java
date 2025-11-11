import java.util.InputMismatchException;
import java.util.Scanner;

public class MathMenuRunner {
    public static void main(String[] args) {
        // Instantiate MathLibrary
        MathLibrary library = new MathLibrary();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        System.out.println("--- Welcome to the Geometry Calculator ---");

        // Loop until the user chooses to exit (option 6)
        while (choice != 6) {
            // Display the menu
            System.out.println("\nPlease select a calculation:");
            System.out.println("1. Calculate Circumference (Circle)");
            System.out.println("2. Calculate Area (Circle)");
            System.out.println("3. Calculate Volume (Cylinder)");
            System.out.println("4. Calculate Volume (Cone)");
            System.out.println("5. Calculate Volume (Sphere)");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice (1-6): ");

            try {
                // Read the user's choice
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    // Handle non-integer input
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    scanner.next(); // Consume the invalid input
                    continue; // Skip the rest of the loop and show menu again
                }
                
                // Variables to store input dimensions
                double radius = 0.0;
                double height = 0.0;
                double result = 0.0;

                // Use a switch statement to handle the selection
                switch (choice) {
                    case 1: // Circumference
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        result = library.circumference(radius);
                        System.out.printf("Circumference of a circle with radius %.2f is: %.2f%n", radius, result);
                        break;
                        
                    case 2: // Area Circle
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        result = library.areaCircle(radius);
                        System.out.printf("Area of a circle with radius %.2f is: %.2f%n", radius, result);
                        break;
                        
                    case 3: // Volume Cylinder
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        System.out.print("Enter height: ");
                        height = scanner.nextDouble();
                        result = library.volCylinder(radius, height);
                        System.out.printf("Volume of a cylinder with radius %.2f and height %.2f is: %.2f%n", radius, height, result);
                        break;
                        
                    case 4: // Volume Cone
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        System.out.print("Enter height: ");
                        height = scanner.nextDouble();
                        result = library.volCone(radius, height);
                        System.out.printf("Volume of a cone with radius %.2f and height %.2f is: %.2f%n", radius, height, result);
                        break;
                        
                    case 5: // Volume Sphere
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        result = library.volSphere(radius);
                        System.out.printf("Volume of a sphere with radius %.2f is: %.2f%n", radius, result);
                        break;
                        
                    case 6: // Exit
                        System.out.println("Thank you for using the Geometry Calculator. Goodbye!");
                        break;
                        
                    default: // Invalid choice
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                        break;
                }
            } catch (InputMismatchException e) {
                // Handle non-numeric input for radius/height
                System.out.println("Error: Please enter a valid numeric value for the dimensions.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
        
        scanner.close();
    }
}

