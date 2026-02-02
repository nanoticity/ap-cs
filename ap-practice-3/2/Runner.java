import java.util.ArrayList;
import java.util.List;

public class Runner {
  public static void main(String[] args) {
    ArrayList<LogMessage> messageList = new ArrayList<LogMessage>();
    messageList.add(new LogMessage("CLIENT3:security alert – repeated login failures"));
    messageList.add(new LogMessage("Webserver:disk offline"));
    messageList.add(new LogMessage("SERVER1:file not found"));
    messageList.add(new LogMessage("SERVER2:read error on disk DSK1"));
    messageList.add(new LogMessage("SERVER1:write error on disk DSK2"));
    messageList.add(new LogMessage("Webserver:error on /dev/disk"));

    SystemLog test1 = new SystemLog(messageList);

    // print the original messageList
    System.out.println("***Original messages***");
    for (LogMessage each : messageList) {
      System.out.println(each);
    }

    // print the removed messages
    System.out.println("\n\n***Removed messages that contains disk***");
    List<LogMessage> removedMessages = test1.removeMessages("disk");
    for (LogMessage each : removedMessages) {
      System.out.println(each);
    }

    // print the new messageList
    System.out.println("\n\n***Updated messages list***");
    for (LogMessage each : messageList) {
      System.out.println(each);
    }

  }
}
