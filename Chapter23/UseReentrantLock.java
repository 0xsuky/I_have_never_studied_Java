import java.util.concurrent.locks.ReentrantLock;

class IHaveTwoNumReentrant {
  int num1 = 0;
  int num2 = 0;

  public void addOneNum1() {
    key1.lock();
    try {
      num1 += 1;
    } finally {
      key1.unlock();
    }
  }

  public void addTwoNum1() {
    key1.lock();
    try {
      num1 += 2;
    } finally {
      key1.unlock();
    }
  }

  public void addOneNum2() {
    key2.lock();
    try {
      num2 += 1;
    } finally {
      key2.unlock();
    }
  }

  public void addTwoNum2() {
    key2.lock();
    try {
      num2 += 2;
    } finally {
      key2.unlock();
    }
  }

  public void showAllNums() {
    System.out.println("num1 : " + num1);
    System.out.println("num2 : " + num2);
  }

  private final ReentrantLock key1 = new ReentrantLock();
  private final ReentrantLock key2 = new ReentrantLock();
}

class AccessThreadReentrant extends Thread {
  IHaveTwoNumReentrant twoNumInst;

  public AccessThreadReentrant(IHaveTwoNumReentrant inst) {
    twoNumInst = inst;
  }

  public void run() {
    twoNumInst.addOneNum1();
    twoNumInst.addTwoNum1();
    twoNumInst.addOneNum2();
    twoNumInst.addTwoNum2();
  }
}

public class UseReentrantLock {
  public static void main(String[] args) {
    IHaveTwoNumReentrant numInst = new IHaveTwoNumReentrant();

    AccessThreadReentrant at1 = new AccessThreadReentrant(numInst);
    AccessThreadReentrant at2 = new AccessThreadReentrant(numInst);

    at1.start();
    at2.start();

    try {
      at1.join();
      at2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    numInst.showAllNums();
  }
}
