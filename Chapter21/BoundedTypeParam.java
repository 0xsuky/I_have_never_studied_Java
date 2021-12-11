interface SimpleInterface {
  public void showYourName();
}

class UpperClass {
  public void showYourAncestor() {
    System.out.println("UpperClass");
  }
}

class AAA extends UpperClass implements SimpleInterface {
  public void showYourName() {
    System.out.println("Class AAA");
  }
}

class BBB extends UpperClass implements SimpleInterface {
  public void showYourName() {
    System.out.println("Class BBB");
  }
}

public class BoundedTypeParam {
  public static <T> void showInstanceAncestor(T param) {
    ((SimpleInterface) param).showYourName();
  }

  public static <T> void showInstanceName(T param) {
    ((UpperClass) param).showYourAncestor();
  }

  public static void main(String[] args) {
    AAA aaa = new AAA();
    BBB bbb = new BBB();

    showInstanceAncestor(aaa);
    showInstanceName(aaa);
    showInstanceAncestor(bbb);
    showInstanceName(bbb);
  }
}
