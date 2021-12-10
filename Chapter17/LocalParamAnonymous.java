interface Readable {
  public void read();
}

class OuterClass {
  private String myName;

  OuterClass(String name) {
    myName = name;
  }

  public Readable createLocalClassInst(final int instID) {
    return new Readable() {
      public void read() {
        System.out.println("Outer inst name : " + myName);
        System.out.println("Local inst ID : " + instID);
      }
    };
  }
}

public class LocalParamAnonymous {
  public static void main(String[] args) {
    OuterClass out = new OuterClass("My Outer Class");
    Readable localInst1 = out.createLocalClassInst(111);
    localInst1.read();

    Readable localInst2 = out.createLocalClassInst(222);
    localInst2.read();
  }
}