import java.util.Scanner;

public class Runner {

    private Scanner scan = new Scanner(System.in);
    private Profile p1 = new Profile();
    private Profile p2 = new Profile();
    private Profile p3 = new Profile(); 

    private void printMenu() {
        System.out.println("\n\nSTATUS:");
        System.out.println("Profile 1:");
        p1.printInfo();
        System.out.println("\nProfile 2:");
        p2.printInfo();
        System.out.println("\nProfile 3:");
        p3.printInfo();

        System.out.println("\n\nMENU:");

        System.out.println("What profile do you want to update? enter 1 2 or 3 (or enter 0 to quit)");
        int profile = scan.nextInt();
        scan.nextLine();

        if (profile == 0) {
            System.out.println("Exiting program.");
            System.exit(0);
        }

        System.out.println("Enter name:");
        String name = scan.nextLine();

        System.out.println("Enter age:");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.println("\nEnter subject:");
        System.out.println("1. math");
        System.out.println("2. history");
        System.out.println("3. science");
        int subjectInt = scan.nextInt();

        System.out.println("\nEnter hobby:");
        System.out.println("1. piano");
        System.out.println("2. sailing");
        System.out.println("3. soccer");
        int hobbyInt = scan.nextInt();

        System.out.println("\nEnter food:");
        System.out.println("1. burger");
        System.out.println("2. tacos");
        System.out.println("3. sushi");

        int foodInt = scan.nextInt();

        scan.nextLine();

        String subject;
        switch (subjectInt) {
            case 1:
                subject = "math";
                break;
            case 2:
                subject = "history";
                break;
            case 3:
                subject = "science";
                break;
            default:
                subject = "unknown";
                break;
        }

        String hobby;
        switch (hobbyInt) {
            case 1:
                hobby = "piano";
                break;
            case 2:
                hobby = "sailing";
                break;
            case 3:
                hobby = "soccer";
                break;
            default:
                hobby = "unknown";
                break;
        }

        String food;
        switch (foodInt) {
            case 1:
                food = "burger";
                break;
            case 2:
                food = "tacos";
                break;
            case 3:
                food = "sushi";
                break;
            default:
                food = "unknown";
                break;
        }


        switch (profile) {
            case 1:
                p1.updateProfile(name, age, subject, hobby, food);
                System.out.println("\n");
                p1.printInfo();
                System.out.println("\n");
                break;
            case 2:
                p2.updateProfile(name, age, subject, hobby, food);
                System.out.println("\n");
                p2.printInfo();
                System.out.println("\n");
                break;
            case 3:
                p3.updateProfile(name, age, subject, hobby, food);
                System.out.println("\n");
                p3.printInfo();
                System.out.println("\n");
                break;
            default:
                System.out.println("Invalid profile number.");
                break;
        }

        

    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        while (true) {
            runner.printMenu();

            System.out.println("Do you want to update another profile? (yes/no)");
            String response = runner.scan.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}
