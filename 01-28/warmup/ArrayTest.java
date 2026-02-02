import java.util.Random;

public class ArrayTest {

  private int[] numArray;

  public ArrayTest(int size) {
    if (size < 0) {
      size = 0;
    }

    numArray = new int[size];
    Random rnd = new Random();

    for (int i = 0; i < numArray.length; i++) {
      numArray[i] = rnd.nextInt(5);
    }
  }

  public void printArray() {
    for (int val : numArray) {
      System.out.print(val + " ");
    }
    System.out.println();
    System.out.println();
  }

  public int search(int target) {
    for (int i = 0; i < numArray.length; i++) {
      if (numArray[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public void scramble() {
    Random rnd = new Random();

    for (int i = numArray.length - 1; i > 0; i--) {
      int j = rnd.nextInt(i + 1);

      int tmp = numArray[i];
      numArray[i] = numArray[j];
      numArray[j] = tmp;
    }
  }

  public void sort() {

    for (int i = 0; i < numArray.length - 1; i++) {

      for (int j = 0; j < numArray.length - 1 - i; j++) {

        if (numArray[j] > numArray[j + 1]) {

          int temp = numArray[j];
          numArray[j] = numArray[j + 1];
          numArray[j + 1] = temp;
        }
      }
    }
  }

  public String toString() {

    String result = "";

    for (int i = 0; i < numArray.length; i++) {
      result += numArray[i];

      if (i < numArray.length - 1) {
        result += " ";
      }
    }

    return result;
  }
}