import java.math.*;

public class SoBigInteger {
  public static void main(String[] args) {
    System.out.println("최대 정수 : " + Long.MAX_VALUE);
    System.out.println("최소 정수 : " + Long.MIN_VALUE);

    BigInteger bigValue1 = new BigInteger("10000000000000000000000000");
    BigInteger bigValue2 = new BigInteger("-9999999999999999999999999");

    BigInteger addResult = bigValue1.add(bigValue2);
    BigInteger mulResult = bigValue1.multiply(bigValue2);

    System.out.println("큰 수의 덧셈결과 : " + addResult);
    System.out.println("큰 수의 곱셈결과 : " + mulResult);
  }
}
