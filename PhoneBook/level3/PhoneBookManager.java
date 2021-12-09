import java.util.Scanner;

public class PhoneBookManager {
  final static int MAX_PB_SIZE = 100;
  private PhoneBook[] pbArr = new PhoneBook[MAX_PB_SIZE];
  private int pbCurIdx = 0;
  final Scanner sc;

  public PhoneBookManager() {
    sc = new Scanner(System.in);
  }

  public void run() {
    int cmd;
    while (true) {
      showMenu();
      cmd = getCmd();
      processCmd(cmd);
    }
  }

  private void showMenu() {
    System.out.println("");
    System.out.println("선택하세요...");
    System.out.println("1. 데이터 입력");
    System.out.println("2. 데이터 검색");
    System.out.println("3. 데이터 삭제");
    System.out.println("4. 프로그램 종료");
  }

  private int getCmd() {
    System.out.print("선택 : ");
    int cmd = sc.nextInt();
    sc.nextLine();
    return cmd;
  }

  private void processCmd(int cmd) {
    switch (cmd) {
      case 1:
        insertPb();
        break;
      case 2:
        searchPb();
        break;
      case 3:
        deletePb();
        break;
      case 4:
        System.out.println("시스템을 종료합니다.");
        System.exit(0);
        break;
      default:
        System.out.println("잘못된 명령어를 입력하셨습니다.");
        break;
    }
  }

  private void insertPb() {
    if (pbCurIdx == 100) {
      System.out.println("데이터가 모두 차있습니다.");
      return;
    }
    System.out.println("데이터 입력을 시작합니다..");
    String[] pbInfo = getPbInfo();
    PhoneBook pbInst = new PhoneBook(pbInfo[0], pbInfo[1], pbInfo[2]);
    pbArr[pbCurIdx++] = pbInst;
    System.out.println("데이터 입력이 완료되었습니다.");
  }

  private void searchPb() {
    if (pbCurIdx == 0) {
      System.out.println("데이터가 비어있습니다.");
      return;
    }
    System.out.println("데이터 검색을 시작합니다..");
    String searchInfo = getSearchInfo();
    showMatchedResult(searchInfo);
    System.out.println("데이터 검색이 완료되었습니다.");
  }

  private void deletePb() {
    if (pbCurIdx == 0) {
      System.out.println("데이터가 비어있습니다.");
      return;
    }
    System.out.println("데이터 삭제를 시작합니다..");
    String searchInfo = getSearchInfo();
    deleteMatchedResult(searchInfo);
    System.out.println("데이터 삭제가 완료되었습니다.");
  }

  private String[] getPbInfo() {
    String[] result = new String[3];
    System.out.print("이름 : ");
    String name = sc.nextLine();
    result[0] = name;
    System.out.print("전화번호 : ");
    String phone = sc.nextLine();
    result[1] = phone;
    System.out.print("생년월일 : ");
    String birth = sc.nextLine();
    result[2] = birth;
    return result;
  }

  private String getSearchInfo() {
    System.out.print("이름 : ");
    String name = sc.nextLine();
    return name;
  }

  private int getMatchedResultIdx(String searchInfo) {
    String[] info;
    for (int i = 0; i < pbCurIdx; i++) {
      info = pbArr[i].getInfo();
      if (info[0].compareTo(searchInfo) == 0) {
        return i;
      }
    }
    return -1;
  }

  private void showMatchedResult(String searchInfo) {
    int pbIdx = getMatchedResultIdx(searchInfo);
    if (pbIdx != -1) {
      pbArr[pbIdx].showPhoneInfo();
    } else {
      System.out.println("검색어와 일치하는 데이터가 없습니다.");
    }
  }

  private void deleteMatchedResult(String searchInfo) {
    int pbIdx = getMatchedResultIdx(searchInfo);
    if (pbIdx == -1) {
      System.out.println("검색어와 일치하는 데이터가 없습니다.");
      return;
    }
    for (int i = pbIdx; i < pbCurIdx; i++) {
      pbArr[i] = pbArr[i + 1];
    }
    pbCurIdx -= 1;
    System.out.println("검색어와 일치하는 데이터를 삭제했습니다.");
  }
}
