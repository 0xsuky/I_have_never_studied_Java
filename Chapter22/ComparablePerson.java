import java.util.Iterator;
import java.util.TreeSet;

class CompPerson implements Comparable<CompPerson> {
  String name;
  int age;

  public CompPerson(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void showData() {
    System.out.printf("%s %d \n", name, age);
  }

  public int compareTo(CompPerson p) {
    if (age > p.age) {
      return 1;
    } else if (age < p.age) {
      return -1;
    } else {
      return 0;
    }
  }
}

public class ComparablePerson {
  public static void main(String[] args) {
    TreeSet<CompPerson> sTree = new TreeSet<CompPerson>();
    sTree.add(new CompPerson("Lee", 24));
    sTree.add(new CompPerson("Hong", 29));
    sTree.add(new CompPerson("Choi", 21));

    Iterator<CompPerson> itr = sTree.iterator();
    while (itr.hasNext()) {
      itr.next().showData();
    }
  }
}
