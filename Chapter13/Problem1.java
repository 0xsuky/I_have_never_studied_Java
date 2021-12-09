public class Problem1 {
  public static void main(String[] args) {
    int[] arr = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
    int min = minValue(arr);
    int max = maxValue(arr);

    System.out.println(min);
    System.out.println(max);
  }

  private static int minValue(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    return min;
  }

  private static int maxValue(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    return max;
  }
}
