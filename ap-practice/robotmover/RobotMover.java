public class RobotMover {

  private String moveSequence;

  /** For Testing Purposes */
  public RobotMover(String moveSequence) {
    this.moveSequence = moveSequence;
  }

  public String getMoveSequence() {
    return moveSequence;
  }

  /**
   * Initalizes moveSequence with numMoves moves, with an equal
   * chance of "up", "down", "left", and "right". Each move is
   * followed by an underscore ("_").
   * Precondition: numMoves > 0
   */
  public RobotMover(int numMoves) {
    /* to be implemented in part (a) */
    moveSequence = "";

    for (int i = 0; i < numMoves; i++) {
      int rNum = (int) (Math.random() * 4 + 1);

      switch (rNum) {
        case 1:
          moveSequence += "up_";
        case 2:
          moveSequence += "down_";
        case 3:
          moveSequence += "left_";
        case 4:
          moveSequence += "right_";
      }
    }
  }

  /**
   * Returns the number of times that str appears in moveSequence
   * Precondition: moveSequence is a valid sequence of moves,
   * each followed by an underscore.
   * Postcondition: moveSequence is unchanged.
   */
  public int countOccurrences(String str) {
    /* to be implemented in part (b) */
    int index = moveSequence.indexOf(str);
    int count = 0;
    while (index != -1) {
      index = moveSequence.indexOf(str, index + 1);
      count += 1;
    }

    return count;
  }

  /* There may be instance variables, constructors,
    and methods that are not shown. */
}
