import java.util.Scanner;
import java.math.*;

public class Problem2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str;
    System.out.print("실수1 : ");
    str = sc.nextLine();
    BigDecimal bc1 = new BigDecimal(str);
    System.out.print("실수2 : ");
    str = sc.nextLine();
    BigDecimal bc2 = new BigDecimal(str);
    System.out.println("두 실수의 차의 절대값 : " + bc1.subtract(bc2).abs());
  }
}
