import java.lang.Math;

public class MyMath {
    public void oddOrEven(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }

    public void quadraticFormula(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - (4 * a * c);
        if (discriminant > 0) {
            double topPlus = -1 * b + Math.sqrt(discriminant);
            double topMinus = -1 * b - Math.sqrt(discriminant);
            System.out.println("Answer 1: " + (topPlus / 2*a));
            System.out.println("Answer 2: " + (topMinus / 2*a));
        } else if (discriminant == 0) {
            double topPlus = -1 * b + Math.sqrt(discriminant);
            System.out.println("Answer 1: " + (topPlus / 2*a));
        } else {
            System.out.println("All roots are nonreal.");
        }

        
    }
}
