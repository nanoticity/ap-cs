public class Runner {

  public static void main(String[] args) {
    ArrayTest at = new ArrayTest(5);

    System.out.println("Before scramble / original array:");
    at.printArray();

    at.scramble();
    System.out.println("After scramble:");
    at.printArray();

    int foundIndex = at.search(0);
    System.out.println("Index of first 0: " + foundIndex);

    at.sort();
    System.out.println("After sort:");
    at.printArray();
  }
}
