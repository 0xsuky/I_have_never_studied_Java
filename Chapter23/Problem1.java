class Sum_ extends Thread {
  int num;

  public Sum_() {
    num = 0;
  }

  public void addNum(int n) {
    num += n;
  }

  public int getNum() {
    return num;
  }
}

class AdderThread_ extends Sum_ {
  int start, end;

  public AdderThread_(int s, int e) {
    start = s;
    end = e;
  }

  public void run() {
    for (int i = start; i <= end; i++) {
      addNum(i);
    }
  }
}

public class Problem1 {
  public static void main(String[] args) {
    AdderThread_ tr1 = new AdderThread_(1, 50);
    AdderThread_ tr2 = new AdderThread_(51, 100);
    tr1.start();
    tr2.start();

    try {
      tr1.join();
      tr2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("1~100까지의 합 : " + (tr1.getNum() + tr2.getNum()));
  }
}
