import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Animal a1 = new Animal();
        a1.printInfo();

        System.out.println("Enter in a animal type: ");
        String type = scan.next();
        System.out.println("Enter in the age for your " + type + ": ");
        int age = scan.nextInt();
        Animal a2 = new Animal(type, age);
        a2.printInfo();
    }
}
