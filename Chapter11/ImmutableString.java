public class ImmutableString {
  public static void main(String[] args) {
    String str1 = "My String";
    String str2 = "My String";
    String str3 = "Your String";

    if (str1 == str2) {
      System.out.println("동일 인스턴스 참조");
    } else {
      System.out.println("다른 인스턴스 참조");
    }
    if (str2 == str3) {
      System.out.println("동일 인스턴스 참조");
    } else {
      System.out.println("다른 인스턴스 참조");
    }
  }
}
