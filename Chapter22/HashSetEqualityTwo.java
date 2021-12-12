import java.util.Iterator;
import java.util.HashSet;

class SimpleNumberTwo {
  int num;

  public SimpleNumberTwo(int n) {
    num = n;
  }

  public String toString() {
    return String.valueOf(num);
  }

  public int hashCode() {
    return num % 3;
  }

  public boolean equals(Object obj) {
    SimpleNumberTwo comp = (SimpleNumberTwo) obj;
    if (comp.num == num) {
      return true;
    } else {
      return false;
    }
  }
}

public class HashSetEqualityTwo {
  public static void main(String[] args) {
    HashSet<SimpleNumberTwo> hSet = new HashSet<SimpleNumberTwo>();
    hSet.add(new SimpleNumberTwo(10));
    hSet.add(new SimpleNumberTwo(20));
    hSet.add(new SimpleNumberTwo(20));

    System.out.println("저장된 데이터 수 : " + hSet.size());

    Iterator<SimpleNumberTwo> itr = hSet.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
