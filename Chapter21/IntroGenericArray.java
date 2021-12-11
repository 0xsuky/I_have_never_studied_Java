public class IntroGenericArray {
  public static <T> void showArrayData(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    String[] stArr = new String[] { "Hi!", "I'm so happy", "Java Generic Programming" };
    showArrayData(stArr);
  }
}
