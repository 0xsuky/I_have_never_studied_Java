import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

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
  private HashSet<PhoneInfo> pbHashSet = new HashSet<PhoneInfo>();
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
    System.out.println("데이터 입력을 시작합니다..");
    System.out.println("1. 일반, 2. 대학, 3. 회사");
    System.out.print("선택>> ");
    try {
      int dataType = sc.nextInt();
      sc.nextLine();
      PhoneInfo pbInst = insertByDataType(dataType);
      boolean isAdded = pbHashSet.add(pbInst);
      if (isAdded == true) {
        System.out.println("이미 저장된 데이터입니다.");
      } else {
        System.out.println("데이터 입력이 완료되었습니다.");
      }
    } catch (MenuChoiceException e) {
      System.out.println(e.getMessage());
      System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
    }
  }

  private PhoneInfo insertByDataType(int dataType) throws MenuChoiceException {
    String[] pbInfo;
    PhoneInfo pbInst;
    switch (dataType) {
      case PB_TYPE.NORMAL:
        pbInfo = getPbInfo();
        pbInst = new PhoneInfo(pbInfo[0], pbInfo[1]);
        break;
      case PB_TYPE.UNIVERSITY:
        pbInfo = getPbUnivInfo();
        pbInst = new PhoneUnivInfo(pbInfo[0], pbInfo[1], pbInfo[2],
            Integer.parseInt(pbInfo[3]));
        break;
      case PB_TYPE.COMPANY:
        pbInfo = getPbCompanyInfo();
        pbInst = new PhoneCompanyInfo(pbInfo[0], pbInfo[1], pbInfo[2]);
        break;
      default:
        throw new MenuChoiceException(dataType);
    }
    return pbInst;
  }

  private void searchPb() {
    if (getHashSetSize() == 0) {
      System.out.println("데이터가 비어있습니다.");
      return;
    }
    System.out.println("데이터 검색을 시작합니다..");
    String searchInfo = getSearchInfo();
    showMatchedResult(searchInfo);
    System.out.println("데이터 검색이 완료되었습니다.");
  }

  private void deletePb() {
    if (getHashSetSize() == 0) {
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

  private PhoneInfo getMatchedResult(String searchInfo) {
    PhoneInfo curPb;
    String name;
    Iterator<PhoneInfo> itr = pbHashSet.iterator();
    while (itr.hasNext()) {
      curPb = itr.next();
      name = curPb.getInfo()[0];
      if (searchInfo.compareTo(name) == 0) {
        return curPb;
      }
    }
    return null;
  }

  private void showMatchedResult(String searchInfo) {
    PhoneInfo pbInst = getMatchedResult(searchInfo);
    if (pbInst != null) {
      pbInst.showPhoneInfo();
    } else {
      System.out.println("검색어와 일치하는 데이터가 없습니다.");
    }
  }

  private void deleteMatchedResult(String searchInfo) {
    PhoneInfo pbInst = getMatchedResult(searchInfo);
    if (pbInst == null) {
      System.out.println("검색어와 일치하는 데이터가 없습니다.");
      return;
    }
    pbHashSet.remove(pbInst);
    System.out.println("검색어와 일치하는 데이터를 삭제했습니다.");
  }

  private int getHashSetSize() {
    return pbHashSet.size();
  }
}
