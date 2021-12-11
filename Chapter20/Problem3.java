import java.util.Random;
import java.util.Scanner;

public class Problem3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("A : ");
    int A = sc.nextInt();
    System.out.print("B : ");
    int B = sc.nextInt();
    sc.close();
    int[] randomArr = getRandomBetweenAB(A, B);
    for (int i = 0; i < 10; i++) {
      System.out.println(i + "번째 랜덤 값 - " + randomArr[i]);
    }
  }

  private static int[] getRandomBetweenAB(int A, int B) {
    Random random = new Random();
    int[] result = new int[10];
    int diff = A - B + 1;
    for (int i = 0; i < 10; i++) {
      result[i] = random.nextInt(diff) + B;
    }
    return result;
  }
}
