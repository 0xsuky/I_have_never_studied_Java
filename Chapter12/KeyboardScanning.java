import java.util.Scanner;

public class KeyboardScanning {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    int num3 = sc.nextInt();
    int sum = num1 + num2 + num3;

    System.out.printf("입력된 정수 %d, %d, %d의 합은 %d\n", num1, num2, num3, sum);
  }
}
