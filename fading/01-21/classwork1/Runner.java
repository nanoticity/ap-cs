import java.util.Scanner;

class ArrayTest {

  public void printArray(int[] a) {
    for (int i : a) {
      System.out.println(i);
    }
    System.out.println();
  }

  public int search(int s, int[] a) {
    for (int i = 0; i < a.length; i++) {
      if (s == a[i]) {
        return i;
      }
    }
    return -1;
  }

  public void scramble(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int j = (int) (Math.random() * a.length);
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }

  public void sort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - i - 1; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }
  }
}

public class Runner {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int[] nums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) (Math.random() * 10);
    }

    ArrayTest test = new ArrayTest();

    test.printArray(nums);
    test.scramble(nums);
    test.printArray(nums);

    System.out.println("Enter in a number:");
    int number = scan.nextInt();

    int index = test.search(number, nums);
    System.out.println(index);

    test.sort(nums);
    test.printArray(nums);
  }
}