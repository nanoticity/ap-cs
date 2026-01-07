import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            int randomNum = (int)(Math.random() * 20); 
            System.out.println(randomNum);
        }

        for (int i = 0; i < 5; i++) {
            int randomNum = 5 + (int)(Math.random() * 6); 
            System.out.println(randomNum);
        }

        for (int i = 0; i < 5; i++) {
            int randomNum = 15 + (int)(Math.random() * 36); 
            System.out.println(randomNum);
        }

        int userNum;

        while (true) {
            System.out.print("Please enter a number greater than 10: ");
            if (scanner.hasNextInt()) {
                userNum = scanner.nextInt();
                if (userNum > 10) {
                    break;
                } else {
                    System.out.println("The number must be greater than 10. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
            }
        }
        
        System.out.println("Generating 5 random numbers between 1 and " + userNum + ":");
        int range = userNum;
        for (int i = 0; i < 5; i++) {
            int randomNum = 1 + (int)(Math.random() * range); 
            System.out.println(randomNum);
        }

        for (int i = 1; i <= 10; i++) {
            int roll1 = 1 + (int)(Math.random() * 6);
            int roll2 = 1 + (int)(Math.random() * 6);
            int diceSum = roll1 + roll2;

            System.out.print(roll1 + ", " + roll2);

            String conditions = "";

            if (roll1 == 1 && roll2 == 1) {
                conditions += "snake eyes";
            }
            
            if (roll1 == roll2) {
                if (!conditions.isEmpty()) conditions += ", ";
                conditions += "same";
            }
            
            if (diceSum % 2 == 0) {
                if (!conditions.isEmpty()) conditions += ", ";
                conditions += "even sum";
            }

            if (!conditions.isEmpty()) {
                System.out.println(" -> " + conditions);
            } else {
                System.out.println();
            }
        }
        
        scanner.close(); 
    }
}
