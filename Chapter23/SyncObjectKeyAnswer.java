class IHaveTwoNumAnswer {
  int num1 = 0;
  int num2 = 0;

  public void addOneNum1() {
    synchronized (key1) {
      num1 += 1;
    }
  }

  public void addTwoNum1() {
    synchronized (key1) {
      num1 += 2;
    }
  }

  public void addOneNum2() {
    synchronized (key2) {
      num2 += 1;
    }
  }

  public void addTwoNum2() {
    synchronized (key2) {
      num2 += 2;
    }
  }

  public void showAllNums() {
    System.out.println("num1 : " + num1);
    System.out.println("num2 : " + num2);
  }

  Object key1 = new Object();
  Object key2 = new Object();
}

class AccessThreadAnswer extends Thread {
  IHaveTwoNumAnswer twoNumInst;

  public AccessThreadAnswer(IHaveTwoNumAnswer inst) {
    twoNumInst = inst;
  }

  public void run() {
    twoNumInst.addOneNum1();
    twoNumInst.addTwoNum1();
    twoNumInst.addOneNum2();
    twoNumInst.addTwoNum2();
  }
}

public class SyncObjectKeyAnswer {
  public static void main(String[] args) {
    IHaveTwoNumAnswer numInst = new IHaveTwoNumAnswer();

    AccessThreadAnswer at1 = new AccessThreadAnswer(numInst);
    AccessThreadAnswer at2 = new AccessThreadAnswer(numInst);

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
