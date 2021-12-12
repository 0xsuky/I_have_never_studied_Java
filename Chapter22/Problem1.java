import java.util.ArrayList;

public class Problem1 {
  public static void main(String[] args) {
    final int MIN_SIZE = 500;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.ensureCapacity(MIN_SIZE);
    arr.ensureCapacity(arr.size() * 2);
  }
}
