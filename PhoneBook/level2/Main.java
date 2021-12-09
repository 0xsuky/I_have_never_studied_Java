import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    run();
  }

  private static void run() {
    int cmd;
    while (true) {
      showMenu();
      cmd = getCmd();
      processCmd(cmd);
    }
  }

  private static void showMenu() {
    System.out.println("");
    System.out.println("선택하세요...");
    System.out.println("1. 데이터 입력");
    System.out.println("2. 프로그램 종료");
  }

  private static int getCmd() {
    System.out.print("선택 : ");
    Scanner sc = new Scanner(System.in);
    int cmd = sc.nextInt();
    sc.close();
    return cmd;
  }

  private static void processCmd(int cmd) {
    switch (cmd) {
      case 1:
        getAndShowUserInfo(); // 입력과 출력을 분리해야하는데 아직 뒷 내용을 배우지 않아 하나로 합침.
        break;
      case 2:
        System.out.println("시스템을 종료합니다.");
        System.exit(0);
        break;
      default:
        System.out.println("잘못된 명령어를 입력하셨습니다.");
        break;
    }
  }

  private static void getAndShowUserInfo() {
    Scanner sc = new Scanner(System.in);
    System.out.print("이름 : ");
    String name = sc.nextLine();
    System.out.print("전화번호 : ");
    String phone = sc.nextLine();
    System.out.print("생년월일 : ");
    String birth = sc.nextLine();
    sc.close();

    PhoneBook phoneBook = new PhoneBook(name, phone, birth);
    phoneBook.showPhoneInfo();
  }
}
