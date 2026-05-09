import java.util.ArrayList;

public class PlayerAnalysis {
    /** The list of all players */
    private ArrayList<Player> playerList;

    public PlayerAnalysis() {
        playerList = new ArrayList<Player>();
        playerList.add(new Player("DJK", 1090));
        playerList.add(new Player("CJL", 2800));
        playerList.add(new Player("JOY", 2000));
        playerList.add(new Player("BEN", 500));
        playerList.add(new Player("PTT", 3500));
        playerList.add(new Player("JAY", 4500));

    }

    /**
     * Returns the ID of the player whose score is closest to targetScore
     * Preconditions: playerList is not null. No elements of playerList are null.
     * playerList is not empty. Postcondition: playerList is unchanged.
     */
    public String playerWithClosestScore(int targetScore) { /* to be implemented */
        int closest = Math.abs(playerList.get(0).getScore() - targetScore);
        Player closestPlayer = playerList.get(0);
        for (Player player : playerList) {
            if (Math.abs(player.getScore() - targetScore) < closest) {
                closestPlayer = player;
                closest = Math.abs(player.getScore() - targetScore);
            }
        }

        return closestPlayer.getID();
    }

    /*
     * There may be instance variables, constructors, and methods that are not
     * shown.
     */
}
