class Circle {
  double rad;
  final double PI;

  public Circle(double r) {
    rad = r;
    PI = 3.14;
  }

  public double getArea() {
    return (rad * rad) * PI;
  }
}

class CircleArea {
  public static void main(String[] args) {
    Circle c = new Circle(1.5);
    System.out.println("반지름이 1.5인 원의 넓이 : " + c.getArea());
  }
}