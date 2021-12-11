public class PhoneCompanyInfo extends PhoneInfo {
  private String company;

  public PhoneCompanyInfo(String name, String phoneNumber, String company) {
    super(name, phoneNumber);
    this.company = company;
  }

  public String[] getInfo() {
    String[] info = new String[3];
    String[] superInfo = super.getInfo();
    info[0] = superInfo[0];
    info[1] = superInfo[1];
    info[2] = company;
    return info;
  }

  public void showPhoneInfo() {
    super.showPhoneInfo();
    System.out.println("company : " + company);
  }
}