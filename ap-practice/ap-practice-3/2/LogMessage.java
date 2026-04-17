
public class LogMessage {

  private final String machineId;
  private final String description;

  /**
   * Precondition: message is a valid log message.
   */
  public LogMessage(String message) {
    String[] parts = message.split(":");
    machineId = parts[0];
    description = parts[1];
  }

  /**
   * Returns true if the description in this log message properly contains
   * keyword;
   *
   * false otherwise.
   */
  public boolean containsWord(String keyword) {
    int index = description.indexOf(keyword);

    while (index != -1) {
      boolean beforeOK = (index == 0)
          || description.charAt(index - 1) == ' ';
      int afterIndex = index + keyword.length();
      boolean afterOK = (afterIndex == description.length())
          || description.charAt(afterIndex) == ' ';

      if (beforeOK && afterOK) {
        return true;
      }

      index = description.indexOf(keyword, index + 1);
    }

    return false;
  }

  public String getMachineId() {
    return machineId;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return machineId + ":" + description;
  }
  // There may be instance variables, constructors, and methods that are not
  // shown.
}

