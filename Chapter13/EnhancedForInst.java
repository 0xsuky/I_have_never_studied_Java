class Number {
  public int num;

  public Number(int num) {
    this.num = num;
  }

  public int getNum() {
    return num;
  }
}

public class EnhancedForInst {
  public static void main(String[] args) {
    Number[] arr = new Number[] { new Number(2), new Number(4), new Number(8) };

    for (Number e : arr) {
      e.num++;
    }

    for (Number e : arr) {
      System.out.print(e.getNum() + " ");
    }

    System.out.println("");

    for (Number e : arr) {
      e = new Number(5);
      e.num += 2;
      System.out.print(e.getNum() + " ");
    }

    System.out.println("");
    for (Number e : arr) {
      System.out.print(e.getNum() + " ");
    }
  }
}
