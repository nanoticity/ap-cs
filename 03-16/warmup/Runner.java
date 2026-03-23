public class Runner {
  public static void main(String[] args) {
    WarmUp w = new WarmUp();

    int[][] my2DArray = w.create2DArray();
    w.print(my2DArray);
    w.replace(my2DArray);
    System.out.println();
    w.print(my2DArray);
  }
}
