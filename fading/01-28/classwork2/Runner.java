import java.util.ArrayList;

class Test {
  private ArrayList<Integer> numList = new ArrayList<Integer>();

  public Test() {
    for (int i = 0; i < 10; i++) {
      numList.add((int) (Math.random() * 10 + 1));
    }
  }

  public void printList() {
    for (int each : numList) {
      System.out.print(each + " ");
    }
    System.out.println();
  }

  public int searchLargest() {
    int min = numList.get(0);
    for (int i = 0; i < numList.size(); i++) {
      if (numList.get(i) < min) {
        min = numList.get(i);
      }
    }
    return min;
  }

  public void searchAndReplace(int a) {
    for (int i = 0; i < numList.size(); i++) {
      if (numList.get(i).equals(a)) {
        numList.set(i, 1000);
      }
    }
  }

  public void searchAndRemove(int a) {
    for (int i = 0; i < numList.size(); i++) {
      if (numList.get(i).equals(a)) {
        numList.remove(a);
        i--;
      }
    }
  }

  public void sort() {
    int temp;
    for (int i = 0; i < numList.size() - 1; i++) {
      for (int j = 0; j < numList.size() - i - 1; j++) {
        if (numList.get(j) > numList.get(j + 1)) {
          temp = numList.get(j + 1);
          numList.set(j + 1, numList.get(j));
          numList.set(j, temp);
        }
      }
    }
  }
}

public class Runner {
  public static void main(String[] args) {
    Test test = new Test();
    test.printList();
    System.out.println(test.searchLargest());
    test.searchAndReplace(5);
    test.printList();
    test.searchAndRemove(2);
    test.printList();
    test.sort();
    test.printList();
  }
}