class MessageSendingThread extends Thread {
  String message;

  public MessageSendingThread(String str) {
    message = str;
  }

  public void run() {
    for (int i = 0; i < 1000000; i++) {
      System.out.println(message + "(" + getPriority() + ")");
    }
  }
}

public class PriorityTestOne {
  public static void main(String[] args) {
    MessageSendingThread tr1 = new MessageSendingThread("First");
    MessageSendingThread tr2 = new MessageSendingThread("Second");
    MessageSendingThread tr3 = new MessageSendingThread("Third");

    tr1.start();
    tr2.start();
    tr3.start();
  }
}
