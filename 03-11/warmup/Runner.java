public class Runner {
  public static void main(String[] args) {
    int[][] nums = new int[2][3];
    for (int r = 0; r < nums.length - 1; r++) {
      for (int c = 0; c < nums[0].length - 1; c++) {
        nums[r][c] = (int) (Math.random() * 9) + 1;
      }
    }
    Array2D a = new Array2D();

    a.print(nums);
    a.scramble(nums);
    System.out.println();
    a.print(nums);
  }
}