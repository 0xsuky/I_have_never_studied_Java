class Point {
  private int xPos, yPos;

  public Point(int x, int y) {
    xPos = x;
    yPos = y;
  }

  public void showPointInfo() {
    System.out.println("[" + xPos + ", " + yPos + "]");
  }
}

class Circle {
  private Point point;
  private int rad;

  public Circle(int xPos, int yPos, int radVal) {
    point = new Point(xPos, yPos);
    rad = radVal;
  }

  public void showCircleInfo() {
    System.out.println("radius : " + rad);
    point.showPointInfo();
  }
}

class Ring {
  private Circle c1, c2;

  public Ring(int xPos1, int yPos1, int rad1, int xPos2, int yPos2, int rad2) {
    c1 = new Circle(xPos1, yPos1, rad1);
    c2 = new Circle(xPos2, yPos2, rad2);
  }

  public void showRingInfo() {
    System.out.println("First Circle Info");
    c1.showCircleInfo();
    System.out.println("Second Circle Info");
    c2.showCircleInfo();
  }
}

public class Problem2 {
  public static void main(String[] args) {
    Ring ring = new Ring(1, 1, 4, 2, 2, 9);
    ring.showRingInfo();
  }
}