class Calculator {
  int opCnt = 0;

  public synchronized int add(int n1, int n2) {
    synchronized (this) {
      opCnt++;
    }
    return n1 + n2;
  }

  public synchronized int min(int n1, int n2) {
    synchronized (this) {
      opCnt++;
    }
    return n1 - n2;
  }

  public void showOpCnt() {
    System.out.println("총 연산 횟수 : " + opCnt);
  }
}

class AddThread extends Thread {
  Calculator cal;

  public AddThread(Calculator cal) {
    this.cal = cal;
  }

  public void run() {
    System.out.println("1+2=" + cal.add(1, 2));
    System.out.println("2+4=" + cal.add(2, 4));
  }
}

class MinThread extends Thread {
  Calculator cal;

  public MinThread(Calculator cal) {
    this.cal = cal;
  }

  public void run() {
    System.out.println("2-1=" + cal.min(2, 1));
    System.out.println("4-2=" + cal.min(4, 2));
  }
}

public class ThreadSyncMethod {
  public static void main(String[] args) {
    Calculator cal = new Calculator();
    AddThread at = new AddThread(cal);
    MinThread mt = new MinThread(cal);

    at.start();
    mt.start();

    try {
      at.join();
      mt.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    cal.showOpCnt();
  }
}
