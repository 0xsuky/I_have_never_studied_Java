class SimpleNumber {
  int num = 0;

  private SimpleNumber() {
  };

  public void addNum(int n) {
    num += n;
  }

  public void showNum() {
    System.out.println(num);
  }

  private static SimpleNumber snInst = null;

  public static SimpleNumber getSimpleNumberInst() {
    if (snInst == null) {
      snInst = new SimpleNumber();
      return snInst;
    }
    return snInst;
  }
}

class OnlyOneInstance {
  public static void main(String[] args) {
    SimpleNumber num1 = SimpleNumber.getSimpleNumberInst();
    num1.addNum(20);

    SimpleNumber num2 = SimpleNumber.getSimpleNumberInst();
    num2.addNum(30);

    num1.showNum();
    num2.showNum();
  }
}
