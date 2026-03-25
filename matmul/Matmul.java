package matmul;

public class Matmul {
  public int[][] a = new int[][] { { 1, 0 }, { 0, 1 } };
  public int[][] c = new int[][] { { 4, 1 }, { 2, 2 } };

  public int[][] matmul(int[][] a, int[][] c) {

    // check dimensions
    if (a[0].length != c.length) {
      System.err.println("Dimensions not compatible between matrices");
      System.exit(1);
    }

    return a;
  }
}