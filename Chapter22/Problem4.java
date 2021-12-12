import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

class StrLenComparator_ implements Comparator<String> {
  public int compare(String str1, String str2) {
    return str1.length() - str2.length();
  }
}

public class Problem4 {
  public static void main(String args[]) {
    TreeSet<String> tSet = new TreeSet<String>(new StrLenComparator_());
    tSet.add("Orange");
    tSet.add("Apple");
    tSet.add("Dog");
    tSet.add("Individual");

    Iterator itr = tSet.descendingIterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
