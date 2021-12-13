import java.util.Scanner;

class AccumulateThread extends Thread {
  private int[] intArr;
  private int acc;
  boolean isSet = false;
  int idx;

  public AccumulateThread() {
    this.intArr = new int[5];
    acc = 0;
    idx = 0;
  }

  private void addNum(int num) {
    synchronized (this) {
      acc += num;
    }
  }

  public void insertNum(int val) {
    synchronized (this) {
      intArr[idx++] = val;
      if (idx == 5) {
        isSet = true;
        notify();
      }
    }
  }

  public void run() {
    synchronized (this) {
      try {
        if (isSet == false) {
          wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for (int e : intArr) {
        addNum(e);
      }
    }
  }

  public int getAcc() {
    return acc;
  }
}

public class Problem2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AccumulateThread at = new AccumulateThread();

    try {
      at.start();
      for (int i = 0; i < 5; i++) {
        at.insertNum(sc.nextInt());
      }
      at.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(at.getAcc());
  }
}
