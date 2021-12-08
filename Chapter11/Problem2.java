public class Problem2 {
  public static void main(String[] args) {
    String str = "990208-1012752";
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch != '-') {
        buf.append(ch);
      }
    }
    System.out.println(buf);
  }
}
