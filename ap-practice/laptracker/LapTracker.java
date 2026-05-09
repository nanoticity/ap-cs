public class LapTracker {
  private int lapCount = 0;
  private int numOfCalls = 0;
  private int resetCalls;

  public LapTracker(int resetCalls) {
    this.resetCalls = resetCalls;
  }

  public int addLaps(int numLaps) {
    if (numOfCalls >= resetCalls) {
      lapCount = 0;
      numOfCalls = 0;
    }
    lapCount += numLaps;
    numOfCalls++;
    return lapCount;
  }
}
