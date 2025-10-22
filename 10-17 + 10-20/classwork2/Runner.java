import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    int i = 8;
    while (i <= 30) {
      System.out.println(i);
      i += 2;
    }
    System.out.println();

    int j = 8;
    do {
      System.out.println(j);
      j += 2;
    } while (j <= 30);
    System.out.println();

    int sum = 0;
    int k = 2;
    while (k <= 19) {
      sum += k;
      k++;
    }
    System.out.println("Sum (while) 2..19 = " + sum);
    System.out.println();

    int sum2 = 0;
    int m = 2;
    do {
      sum2 += m;
      m++;
    } while (m <= 19);
    System.out.println("Sum (do-while) 2..19 = " + sum2);
    System.out.println();

    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a number: ");
    while (!scan.hasNextInt()) {
      System.out.print("Please enter an integer: ");
      scan.next();
    }
    int n = scan.nextInt();
    System.out.println();

    if (n > 0) {
      int t = 1;
      do {
        System.out.println(t);
        t++;
      } while (t <= n);
    } else if (n < 0) {
      int t = -1;
      do {
        System.out.println(t);
        t--;
      } while (t >= n);
    } else { // n == 0
      System.out.println(0);
    }

    scan.close();
  }
}
