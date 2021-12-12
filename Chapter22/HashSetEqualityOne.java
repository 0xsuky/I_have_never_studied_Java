import java.util.Iterator;
import java.util.HashSet;

class SimpleNumber {
  int num;

  public SimpleNumber(int n) {
    num = n;
  }

  public String toString() {
    return String.valueOf(num);
  }
}

public class HashSetEqualityOne {
  public static void main(String[] args) {
    HashSet<SimpleNumber> hSet = new HashSet<SimpleNumber>();
    hSet.add(new SimpleNumber(10));
    hSet.add(new SimpleNumber(20));
    hSet.add(new SimpleNumber(20));

    System.out.println("저장된 데이터 수 : " + hSet.size());

    Iterator<SimpleNumber> itr = hSet.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
