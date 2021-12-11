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

  public void store(T item) {
    this.item = item;
  }

  public T pullOut() {
    return item;
  }
}

public class GenericBaseFruitBox {
  public static void main(String[] args) {
    FruitBox<Orange> fBox1 = new FruitBox<Orange>();
    fBox1.store(new Orange(10));
    Orange org1 = fBox1.pullOut();
    org1.showSugarContent();

    FruitBox<Apple> fBox2 = new FruitBox<Apple>();
    fBox2.store(new Apple(20));
    Apple org2 = fBox2.pullOut();
    org2.showAppleWeight();
  }
}
