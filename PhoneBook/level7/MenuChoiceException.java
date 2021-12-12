public class MenuChoiceException extends Exception {
  public MenuChoiceException(int choice) {
    super(choice + "에 해당하는 선택은 존재하지 않습니다.");
  }
}
