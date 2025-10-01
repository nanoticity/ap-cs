import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        MyMath math = new MyMath();
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose:");
        System.out.println("1: Check if a integer is odd or even");
        System.out.println("2: Quadratic formula");
        System.out.println("Please enter 1 or 2");
        int usr1 = scan.nextInt();

        if (usr1 == 1) {
            System.out.println("Enter the number: ");
            int num = scan.nextInt();
            math.oddOrEven(num);
        } else if (usr1 == 2) {
            System.out.println("Enter a: ");
            Double a = scan.nextDouble();
            System.out.println("Enter b: ");
            Double b = scan.nextDouble();
            System.out.println("Enter c: ");
            Double c = scan.nextDouble();
            math.quadraticFormula(a, b, c);
        }

    }
}
