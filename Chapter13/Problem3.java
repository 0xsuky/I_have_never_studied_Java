public class Problem3 {
  public static void main(String[] args) {
    int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    printTwoDArr(arr);
    swapLineByLine(arr);
    printTwoDArr(arr);
  }

  private static void printTwoDArr(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println("");
    }
  }

  private static void swapLineByLine(int[][] arr) {
    int tmp;
    for (int j = 0; j < arr[0].length; j++) {
      tmp = arr[arr.length - 1][j];
      for (int i = arr.length - 1; i > 0; i--) {
        arr[i][j] = arr[i - 1][j];
      }
      arr[0][j] = tmp;
    }
  }
}
