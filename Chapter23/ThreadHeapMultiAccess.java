class SumMA {
  int num;

  public SumMA() {
    num = 0;
  }

  public void addNum(int n) {
    num += n;
  }

  public int getNum() {
    return num;
  }
}

class AdderThreadMA extends Thread {
  SumMA sumInst;
  int start, end;

  public AdderThreadMA(SumMA sum, int s, int e) {
    sumInst = sum;
    start = s;
    end = e;
  }

  public void run() {
    for (int i = start; i <= end; i++) {
      sumInst.addNum(i);
    }
  }
}

public class ThreadHeapMultiAccess {
  public static void main(String[] args) {
    SumMA s = new SumMA();
    AdderThreadMA at1 = new AdderThreadMA(s, 1, 50);
    AdderThreadMA at2 = new AdderThreadMA(s, 51, 100);
    at1.start();
    at2.start();
    try {
      at1.join();
      at2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("1~100까지의 합 : " + s.getNum());
  }
}
