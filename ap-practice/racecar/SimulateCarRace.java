public class SimulateCarRace {

  private RaceCar carOne;
  private RaceCar carTwo;

  public SimulateCarRace() {
    this.carOne = new RaceCar(1);
    this.carTwo = new RaceCar(2);
  }

  /**
   * Simulates a race with numLaps laps and returns a String indicating the
   * outcome, as described in part (a) Precondition: numLaps > 0
   */
  public String findWinner(int numLaps) {
    /* to be implemented in part (a) */
    double car1total = 0;
    double car2total = 0;
    for (int i = 1; i <= numLaps; i++) {
      car1total += carOne.getLapTime(i);
      car2total += carTwo.getLapTime(i);
    }
    String ret = "";
    if (car1total < car2total) {
      ret = "Car 1 wins!";
    } else if (car2total < car1total) {
      ret = "Car 2 wins!";
    } else if (car2total == car1total) {
      ret = "Tie!";
    }
    return ret;
  }

  /**
   * Returns a shortened version of the parameter message with all substrings that
   * are equal to the parameter str removed, as described in part (b)
   * Precondition: There are no overlapping occurrences of str within message.
   */
  public String shortenMessage(String message, String str) {
    /* to be implemented in part (b) */
    String ret = message.replace(str, "");
    return ret;
  }

  /*
   * There may be instance variables, constructors, and methods that are not
   * shown.
   */
}
