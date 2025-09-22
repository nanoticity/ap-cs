import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Formulas formulas = new Formulas();
        Scanner scan = new Scanner(System.in);

        while (true) {
            
            int choice = formulas.displayMenu();
            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 1) {
                formulas.areaOfRect();
            } else if (choice == 2) {
                formulas.areaOfCircle();
            } else if (choice == 3) {
                formulas.areaOfParallelogram();
            } else if (choice == 4) {
                formulas.areaOfEllipse();
            } else if (choice == 5) {
                formulas.distanceFormula();
            }  else if (choice == 6) {
                formulas.slopeFormula();
            } else if (choice == 7) {
                formulas.simpleInterest();
            } else if (choice == 8) {
                formulas.permieterOfRect();
            } else if (choice == 9) {
                formulas.volumeOfRectPrism();
            } else if (choice == 10) {
                formulas.volumeOfCylinder();
            } else if (choice == 11) {
                formulas.volumeOfCone();
            } else if (choice == 12) {
                formulas.areaOfTrapezoid();
            } else if (choice == 13) {
                formulas.geometricMean();
            } else if (choice == 14) {
                formulas.harmonicMean();
            } else if (choice == 15) {
                formulas.GCD();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scan.nextLine();
        }

    }
    
}
