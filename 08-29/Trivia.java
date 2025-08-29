import java.util.Scanner;

public class Trivia {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String question1, question2, question3, question4, question5, question6;
        question1 = "What is the capital of France?";
        question2 = "What city are we in now?";
        question3 = "What is 2 + 2? Answer in word form.";
        question4 = "What is the first two words of this question?";
        question5 = "What is the last word of this question?";
        question6 = "What is my full name?";
        int count = 0;

        System.out.println("Here are some trivia questions:");
        System.out.println(question1);

        String answer1 = scan.next();
        if (answer1.equals("paris")) {
            count++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect");
        }
        System.out.println(question2);

        scan.nextLine();

        String answer2 = scan.nextLine();
        if (answer2.equals("mountain view")) {
            count++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect");
        }
        System.out.println(question3);

        String answer3 = scan.next();
        if (answer3.equals("four")) {
            count++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect");
        }
        System.out.println(question4);

        scan.nextLine();

        String answer4 = scan.nextLine();
        if (answer4.equals("what is")) {
            count++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect");
        }
        System.out.println(question5);

        String answer5 = scan.next();
        if (answer5.equals("question")) {
            count++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect");
        }
        System.out.println(question6);
        scan.nextLine();

        String answer6 = scan.nextLine();
        if (answer6.equals("ari nemet")) {
            count++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect");
        }

        System.out.println("You got " + count + " out of 6 correct.");
    }    
}
