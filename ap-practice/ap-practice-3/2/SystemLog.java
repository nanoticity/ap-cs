
import java.util.ArrayList;
import java.util.List;

public class SystemLog {

  /**
   * Contains all the entries in this system log. Guaranteed not to be null
   * and to contain only non-null entries.
   */
  private final List<LogMessage> messageList;

  public SystemLog(List<LogMessage> messageList) {
    this.messageList = messageList;
  }

  /**
   * Removes from the system log all entries whose descriptions properly
   * contain keyword, and returns a list (possibly empty) containing the
   * removed entries. Postcondition:
   *
   * - Entries in the returned list properly contain keyword and
   *
   * are in the order in which they appeared in the system log.
   *
   * - The remaining entries in the system log do not properly contain keyword
   * and
   *
   * are in their original order.
   *
   * - The returned list is empty if no messages properly contain keyword.
   */
  public List<LogMessage> removeMessages(String keyword) {
    /* to be implemented in part (c) */
    List<LogMessage> ans = new ArrayList<>();
    for (LogMessage lm : messageList) {
      if (lm.containsWord(keyword)) {
        ans.add(lm);
      }
    }

    return ans;
  }

  // There may be instance variables, constructors, and methods that are not
  // shown.
}
