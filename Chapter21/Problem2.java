class MyClass {
  public <T> void simpleMethod(T param) {
    // param.showData(); // param에 showData 메소드가 반드시 있다는 보장이 없음
    System.out.println(param);
  }
}
