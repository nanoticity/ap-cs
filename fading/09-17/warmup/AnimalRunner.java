import java.util.Scanner;

public class AnimalRunner {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the type of animal:");
        String type = scan.nextLine();
        System.out.println("Enter the age of the animal in years:");
        int years = scan.nextInt();
        myAnimal.setVariables(type, years);
        myAnimal.printInfo();
    }
}
