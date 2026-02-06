import java.util.ArrayList;

public class Runner {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    

    for (int i = 0; i < 10; i++) {
      numbers.add((int) (Math.random() * 10) + 1);
    }

    ArrayListTest obj = new ArrayListTest();

    obj.print(numbers);
    obj.sort(numbers);
    obj.print(numbers);
  }
}
