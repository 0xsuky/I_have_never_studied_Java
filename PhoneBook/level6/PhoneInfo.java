public class PhoneInfo {
  private String name;
  private String phoneNumber;

  public PhoneInfo(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String[] getInfo() {
    String[] info = new String[2];
    info[0] = name;
    info[1] = phoneNumber;
    return info;
  }

  public void showPhoneInfo() {
    System.out.println("");
    System.out.println("입력된 정보 출력...");
    System.out.println("name : " + name);
    System.out.println("phone : " + phoneNumber);
  }
}