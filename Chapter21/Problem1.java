class Orange {
  int sugarContent;

  public Orange(int sugar) {
    sugarContent = sugar;
  }

  public void showSugarContent() {
    System.out.println("당도 " + sugarContent);
  }
}

class Apple {
  int weight;

  public Apple(int weight) {
    this.weight = weight;
  }

  public void showAppleWeight() {
    System.out.println("무게 " + weight);
  }
}

class FruitBox<T> {
  T item;

  public FruitBox(T item) {
    this.item = item;
  }

  public void store(T item) {
    this.item = item;
  }

  public T pullOut() {
    return item;
  }
}

public class Problem1 {
  public static void main(String[] args) {
    FruitBox<Orange> orBox = new FruitBox<Orange>(new Orange(10));
    Orange org = orBox.pullOut();
    org.showSugarContent();

    FruitBox<Apple> apBox = new FruitBox<Apple>(new Apple(20));
    Apple app = apBox.pullOut();
    app.showAppleWeight();
  }
}
