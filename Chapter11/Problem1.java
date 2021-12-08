public class Problem1 {
  public static void main(String[] args) {
    String str = "ABCDEFGHIJKLMN";
    StringBuilder buf = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      buf.append(str.charAt(i));
    }
    System.out.println(buf);
  }
}
