class Kid {
  int numOfMarble;

  public Kid(int num) {
    numOfMarble = num;
  }

  public void win(Kid kid, int num) {
    changeMarble(num);
    kid.changeMarble(-num);
  }

  public void changeMarble(int num) {
    numOfMarble += num;
  }

  public void showCurrentStatue() {
    System.out.println("현재 구슬 상태는 " + numOfMarble + "개 입니다.");
  }
}

class Problem2 {
  public static void main(String[] args) {
    Kid kid1 = new Kid(15);
    Kid kid2 = new Kid(9);

    // 1차 게임에서 어린이1은 어린이2의 구슬 2개를 획득한다.
    kid1.win(kid2, 2);

    // 2차 게임에서 어린이2는 어린이1의 구술 7개를 획득한다.
    kid2.win(kid1, 7);

    System.out.println("kid1의 현재 상태: ");
    kid1.showCurrentStatue();
    System.out.println("kid2의 현재 상태: ");
    kid2.showCurrentStatue();
  }
}
