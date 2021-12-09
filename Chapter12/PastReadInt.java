import java.io.*;

public class PastReadInt {
  public static void main(String[] args) {
    try {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      System.out.print("정수 입력 : ");
      String str = br.readLine();
      int num = Integer.parseInt(str);
      System.out.println("입력된 정수 : " + num);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
