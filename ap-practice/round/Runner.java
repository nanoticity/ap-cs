
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        String[] players = {"Alex", "Ben", "Cara"};
        Round round = new Round(players);

        System.out.println("Testing Part A:");
        round.printCompetitors();

        System.out.println("\nTesting Part B:");
        System.out.println("Even Numbers of Competitors:");
        ArrayList<Match> matches = round.buildMatches();
        for (int i = 0; i < matches.size(); i++) {
            System.out.println(i + 1 + ". " + matches.get(i));
        }

        System.out.println("Odd Numbers of Competitors:");

        players = new String[]{"Rei", "Sam", "Vi", "Tim"};
        round = new Round(players);
        matches = round.buildMatches();
        for (int i = 0; i < matches.size(); i++) {
            System.out.println(i + 1 + ". " + matches.get(i));
        }
    }
}
