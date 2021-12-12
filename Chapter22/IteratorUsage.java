import java.util.Iterator;
import java.util.LinkedList;

public class IteratorUsage {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<String>();
    list.add("First");
    list.add("Second");
    list.add("Third");
    list.add("Fourth");

    Iterator<String> itr = list.iterator();

    System.out.println("반복자를 이용한 1차 출력과 \"Third\" 삭제");
    while (itr.hasNext()) {
      String curStr = itr.next();
      System.out.println(curStr);
      if (curStr.compareTo("Third") == 0) {
        itr.remove();
      }
    }

    System.out.println("\n\"Third\" 삭제 후 반복자를 이용한 2차 출력 ");
    itr = list.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
