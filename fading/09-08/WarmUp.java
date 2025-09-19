import java.util.Scanner;

public class WarmUp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a verb: ");
        String verb = scan.nextLine();

        System.out.print("Enter a noun: ");
        String noun = scan.nextLine();

        String sentence = "The " + noun + " " + verb + "s.";
        System.out.println(sentence);
    }
}
