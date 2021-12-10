class Box {
  private void simpleWrap() {
    System.out.println("simple wrap");
  }

  public void wrap() {
    simpleWrap();
  }
}

class PaperBox extends Box {
  private void paperWrap() {
    System.out.println("paper wrap");
  }

  public void wrap() {
    paperWrap();
  }
}

class GoldPaperBox extends PaperBox {
  private void goldWrap() {
    System.out.println("gold wrap");
  }

  public void wrap() {
    goldWrap();
  }
}

class Problem1 {
  public static void wrapBox(Box box) {
    box.wrap();
  }

  public static void main(String[] args) {
    Box box1 = new Box();
    PaperBox box2 = new PaperBox();
    GoldPaperBox box3 = new GoldPaperBox();

    wrapBox(box1);
    wrapBox(box2);
    wrapBox(box3);
  }
}
