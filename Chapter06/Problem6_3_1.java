class Pow {
  public static void main(String[] args) {
    int n = 10;
    System.out.println(pow(n));
  }

  public static int pow(int n) {
    if (n == 0) {
      return 1;
    } else {
      return 2 * pow(n - 1);
    }
  }
}