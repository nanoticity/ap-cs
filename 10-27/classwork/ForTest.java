public class ForTest {
    public void printCount() {
        for (int i = 0; i <=100; i ++) {
            System.out.println(i);
        }
    }

    public void printCount(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public void printCount(int one, int two) {
        for (int i = one; i <= two; i++) {
            System.out.println(i);
        }
    }

  public int getFactorial(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result = result * i;
    }
    return result;
  }

    public void drawBox() {
        int rows = 5;
        int cols = 10;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}