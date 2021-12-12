public class PhoneUnivInfo extends PhoneInfo {
  private String major;
  private int year;

  public PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
    super(name, phoneNumber);
    this.major = major;
    this.year = year;
  }

  public String[] getInfo() {
    String[] info = new String[4];
    String[] superInfo = super.getInfo();
    info[0] = superInfo[0];
    info[1] = superInfo[1];
    info[2] = major;
    info[3] = Integer.toString(year);
    return info;
  }

  public void showPhoneInfo() {
    super.showPhoneInfo();
    System.out.println("major : " + major);
    System.out.println("year : " + year);
  }
}