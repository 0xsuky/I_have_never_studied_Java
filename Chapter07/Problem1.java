class Triangle {
  int height;
  int bottom;

  public Triangle(int h, int b) {
    setProps(h, b);
  }

  public void setProps(int h, int b) {
    height = h;
    bottom = b;
  }

  public double getArea() {
    return (double) h * b / 2;
  }
}