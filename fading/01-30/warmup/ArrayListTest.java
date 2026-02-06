import java.util.ArrayList;

public class ArrayListTest {
  public void print(ArrayList<Integer> a) {
    for (int each : a) {
      System.out.print(a + " ");
    }
    System.out.println();
  }

  public void sort(ArrayList<Integer> list) {
    Integer temp;
    boolean sorted = false;

    while (!sorted) {
      sorted = true;
      for (int i = 0; i < list.size()-1; i++) {
        if (list.get(i) > list.get(i + 1)) {
          temp = list.get(i);
          list.set(i, list.get(i + 1));
          list.set(i + 1, temp);
          sorted = false;
        }
      }
    }
  } 

}
