public class MethodDefAdd {
  public static void main(String[] args) {
    System.out.println("프로그램의 시작");
    hiEveryOne(12);
    hiEveryOne(13);
    System.out.println("프로그램의 끝");
  }

  public static void hiEveryOne(int age) {
    System.out.println("좋은 아침입니다.");
    System.out.println("제 나이는 " + age + "세입니다.");
  }
}
