public class Array2D {
  public void print(int[][] nums) {
    for (int[] array : nums) {
      for (int n : array) {
        System.out.print(n + "\t");
      }
      System.out.println();
    }
  }

  void scramble(int[][] ar) {
    for (int i = ar.length - 1; i > 0; i--) {
      for (int j = ar[0].length - 1; j > 0; j--) {
        int ri = (int) (Math.random() * (i + 1));
        int rj = (int) (Math.random() * (j + 1));
        int temp = ar[i][j];
        ar[i][j] = ar[ri][rj];
        ar[ri][rj] = temp;
      }
    }
  }
}
