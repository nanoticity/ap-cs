public class Runner {
  public static void main(String[] args) {
    ArrayTest at = new ArrayTest();
    System.out.println("Before sorting: " + at);
    at.sort();
    System.out.println("After sorting: " + at);
  }
}