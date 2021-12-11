import java.util.Scanner;

interface MENU_TYPE {
  int INSERT = 1;
  int SEARCH = 2;
  int DELETE = 3;
  int EXIT = 4;
}

interface PB_TYPE {
  int NORMAL = 1;
  int UNIVERSITY = 2;
  int COMPANY = 3;
}

public class PhoneBookManager {
  final static int MAX_PB_SIZE = 100;
  private PhoneInfo[] pbArr = new PhoneInfo[MAX_PB_SIZE];
  private int pbCurIdx = 0;
  final Scanner sc;
  private static PhoneBookManager inst = null;

  private PhoneBookManager() {
    sc = new Scanner(System.in);
  }

  public static PhoneBookManager getInstance() {
    if (inst != null) {
      return null;
    }
    inst = new PhoneBookManager();
    return inst;
  }

  public void run() {
    int cmd;
    while (true) {
      try {
        showMenu();
        cmd = getCmd();
        processCmd(cmd);
      } catch (MenuChoiceException e) {
        System.out.println(e.getMessage());
        System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
      }
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

  private void processCmd(int cmd) throws MenuChoiceException {
    switch (cmd) {
      case MENU_TYPE.INSERT:
        insertPb();
        break;
      case MENU_TYPE.SEARCH:
        searchPb();
        break;
      case MENU_TYPE.DELETE:
        deletePb();
        break;
      case MENU_TYPE.EXIT:
        System.out.println("시스템을 종료합니다.");
        System.exit(0);
        break;
      default:
        throw new MenuChoiceException(cmd);
    }
  }

  private void insertPb() {
    if (pbCurIdx == 100) {
      System.out.println("데이터가 모두 차있습니다.");
      return;
    }
    System.out.println("데이터 입력을 시작합니다..");
    System.out.println("1. 일반, 2. 대학, 3. 회사");
    System.out.print("선택>> ");
    try {
      int dataType = sc.nextInt();
      sc.nextLine();
      insertByDataType(dataType);
      System.out.println("데이터 입력이 완료되었습니다.");
    } catch (MenuChoiceException e) {
      System.out.println(e.getMessage());
      System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
    }
  }

  private void insertByDataType(int dataType) throws MenuChoiceException {
    switch (dataType) {
      case PB_TYPE.NORMAL:
        String[] pbInfo = getPbInfo();
        PhoneInfo pbInst = new PhoneInfo(pbInfo[0], pbInfo[1]);
        pbArr[pbCurIdx++] = pbInst;
        break;
      case PB_TYPE.UNIVERSITY:
        String[] pbUnivInfo = getPbUnivInfo();
        PhoneInfo pbUnivInst = new PhoneUnivInfo(pbUnivInfo[0], pbUnivInfo[1], pbUnivInfo[2],
            Integer.parseInt(pbUnivInfo[3]));
        pbArr[pbCurIdx++] = pbUnivInst;
        break;
      case PB_TYPE.COMPANY:
        String[] pbCompanyInfo = getPbCompanyInfo();
        PhoneInfo pbCompanyInst = new PhoneCompanyInfo(pbCompanyInfo[0], pbCompanyInfo[1], pbCompanyInfo[2]);
        pbArr[pbCurIdx++] = pbCompanyInst;
        break;
      default:
        throw new MenuChoiceException(dataType);
    }
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
    String[] result = new String[2];
    System.out.print("이름 : ");
    String name = sc.nextLine();
    result[0] = name;
    System.out.print("전화번호 : ");
    String phone = sc.nextLine();
    result[1] = phone;
    return result;
  }

  private String[] getPbUnivInfo() {
    String[] result = new String[4];
    System.out.print("이름 : ");
    String name = sc.nextLine();
    result[0] = name;
    System.out.print("전화번호 : ");
    String phone = sc.nextLine();
    result[1] = phone;
    System.out.print("전공 : ");
    String major = sc.nextLine();
    result[2] = major;
    System.out.print("학년 : ");
    String year = sc.nextLine();
    result[3] = year;
    return result;
  }

  private String[] getPbCompanyInfo() {
    String[] result = new String[3];
    System.out.print("이름 : ");
    String name = sc.nextLine();
    result[0] = name;
    System.out.print("전화번호 : ");
    String phone = sc.nextLine();
    result[1] = phone;
    System.out.print("회사 : ");
    String company = sc.nextLine();
    result[2] = company;
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
