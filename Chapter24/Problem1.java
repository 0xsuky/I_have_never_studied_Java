import java.io.*;

class MyInfo {
  String info;

  public MyInfo(String info) {
    this.info = info;
  }

  public String toString() {
    return info;
  }
}

public class Problem1 {
  public static void main(String[] args) throws IOException {
    FileOutputStream fos = new FileOutputStream("println.txt");
    PrintStream systemOut = new PrintStream(fos);
    MyInfo mInfo = new MyInfo("저는 자바 프로그래머입니다.");
    systemOut.println("제 소개를 하겠습니다.");
    systemOut.println(mInfo);
    systemOut.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
  }
}
