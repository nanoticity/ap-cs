public class WarmUp {
  public int[][] create2DArray() {
    int[][] a = new int[4][5];
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[0].length; c++) {
        a[r][c] = (int) (Math.random() * 5) + 1;
      }
    }
    return a;
  }

  public void print(int[][] a) {
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[0].length; c++) {
        System.out.print(a[r][c] + "\t");
      }
      System.out.println();
    }
  }

  public void replace(int[][] a) {
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[0].length; c++) {
        if (a[r][c] == 1) {
          a[r][c] = 0;
        }
      }
    }
  }
}
