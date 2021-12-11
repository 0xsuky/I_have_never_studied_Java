class Point {
  int xPos, yPos;

  public Point(int x, int y) {
    xPos = x;
    yPos = y;
  }

  public void showPosition() {
    System.out.printf("[%d, %d]", xPos, yPos);
  }

  public boolean equals(Object obj) {
    if (xPos == ((Point) obj).xPos && yPos == ((Point) obj).yPos) {
      return true;
    } else {
      return false;
    }
  }
}

class Rectangle {
  Point upperLeft, lowerRight;

  public Rectangle(int x1, int y1, int x2, int y2) {
    upperLeft = new Point(x1, y1);
    lowerRight = new Point(x2, y2);
  }

  public void showPosition() {
    System.out.println("직사각형 위치정보...");
    System.out.print("좌 상단 : ");
    upperLeft.showPosition();
    System.out.println("");
    System.out.print("우 하단 : ");
    lowerRight.showPosition();
    System.out.println("\n");
  }

  public boolean equals(Object obj) {
    if (upperLeft.equals(((Rectangle) obj).upperLeft) &&
        lowerRight.equals(((Rectangle) obj).lowerRight)) {
      return true;
    } else {
      return false;
    }
  }
}

public class Problem1 {
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(0, 1, 1, 0);
    Rectangle r2 = new Rectangle(0, 2, 2, 0);
    Rectangle r3 = new Rectangle(0, 1, 1, 0);

    r1.showPosition();
    r2.showPosition();
    r3.showPosition();

    if (r1.equals(r2)) {
      System.out.println("인스턴스 내용이 동일하다.");
    } else {
      System.out.println("인스턴스 내용이 동일하지 않다.");
    }

    if (r1.equals(r3)) {
      System.out.println("인스턴스 내용이 동일하다.");
    } else {
      System.out.println("인스턴스 내용이 동일하지 않다.");
    }
  }
}
