public class PhoneBook {
  private String name;
  private String phoneNumber;
  private String birthday;

  public PhoneBook(String name, String phoneNumber, String birthday) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.birthday = birthday;
  }

  public PhoneBook(String name, String phoneNumber) {
    this(name, phoneNumber, null);
  }

  public void showPhoneInfo() {
    System.out.println("");
    System.out.println("입력된 정보 출력...");
    System.out.println("name : " + name);
    System.out.println("phone : " + phoneNumber);
    if (birthday != null) {
      System.out.println("birth : " + birthday);
    }
  }
}