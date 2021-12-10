interface TV {
  public void onTV();
}

interface Computer {
  public void dataReceive();
}

class IPTV implements TV, Computer {
  public void onTV() {
    System.out.println("영상 출력 중");
  }

  public void dataReceive() {
    System.out.println("영상 데이터 수신 중");
  }

  public void powerOn() {
    dataReceive();
    onTV();
  }
}

public class Problem1 {
  public static void main(String[] args) {
    IPTV iptv = new IPTV();
    iptv.powerOn();

    TV tv = iptv;
    Computer comp = iptv;
  }
}
