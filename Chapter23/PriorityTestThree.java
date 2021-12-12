class MessageSendingThreadThree extends Thread {
  String message;

  public MessageSendingThreadThree(String str, int prio) {
    message = str;
    setPriority(prio);
  }

  public void run() {
    for (int i = 0; i < 1000000; i++) {
      System.out.println(message + "(" + getPriority() + ")");

      try {
        sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class PriorityTestThree {
  public static void main(String[] args) {
    MessageSendingThreadThree tr1 = new MessageSendingThreadThree("First", Thread.MAX_PRIORITY);
    MessageSendingThreadThree tr2 = new MessageSendingThreadThree("Second", Thread.NORM_PRIORITY);
    MessageSendingThreadThree tr3 = new MessageSendingThreadThree("Third", Thread.MIN_PRIORITY);

    tr1.start();
    tr2.start();
    tr3.start();
  }
}
