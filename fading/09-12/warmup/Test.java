import java.util.Scanner;

public class Test {
    private double pi = 0.0;
    private int radius = 0;
    private Scanner scan = new Scanner(System.in);

    public void setVariables() {
        System.out.print("Enter the radius of the circle: ");
        radius = scan.nextInt();
        pi = 3.14;
    }
    
    public void printCircumference() {
        double circumference = 2 * pi * radius;
        System.out.println("The circumference of the circle is: " + circumference);
    }

}
