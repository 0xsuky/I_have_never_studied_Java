public class BoxingUnBoxing {
  public static void main(String[] args) {
    Integer iValue = new Integer(10);
    Double dValue = new Double(3.14);

    System.out.println(iValue);
    System.out.println(dValue);

    iValue = new Integer(iValue.intValue() + 10);
    dValue = new Double(dValue.doubleValue() + 1.2);

    System.out.println(iValue);
    System.out.println(dValue);
  }
}
