class FruitSeller {
  private int numOfApple;
  private int myMoney;
  private final int APPLE_PRICE;

  public FruitSeller(int money, int appleNum, int price) {
    myMoney = money;
    numOfApple = appleNum;
    APPLE_PRICE = price;
  }

  public int saleApple(int money) {
    int num = money / APPLE_PRICE;
    numOfApple -= num;
    myMoney += money;
    return num;
  }

  public void showSaleResult() {
    System.out.println("남은 사과 : " + numOfApple);
    System.out.println("판매 수익 : " + myMoney);
  }
}

class FruitBuyer {
  private int myMoney;
  private int numOfApple;

  public FruitBuyer(int money) {
    myMoney = money;
    numOfApple = 0;
  }

  public void buyApple(FruitSeller seller, int money) {
    numOfApple += seller.saleApple(money);
    myMoney -= money;
  }

  public void showBuyResult() {
    System.out.println("현재 잔액 : " + myMoney);
    System.out.println("사과 개수 : " + numOfApple);
  }
}

class FruitSalesMain5 {
  public static void main(String[] args) {
    FruitSeller seller = new FruitSeller(0, 30, 1500);
    FruitBuyer buyer = new FruitBuyer(10000);

    buyer.buyApple(seller, 4500);

    System.out.println("과일 판매자의 현재 상황");
    seller.showSaleResult();

    System.out.println("과일 구매자의 현재 상황");
    buyer.showBuyResult();
  }
}
