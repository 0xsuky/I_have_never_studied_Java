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

public class BoundedTypeParam2 {
  public static <T extends SimpleInterface> void showInstanceAncestor(T param) {
    param.showYourName();
  }

  public static <T extends UpperClass> void showInstanceName(T param) {
    param.showYourAncestor();
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
