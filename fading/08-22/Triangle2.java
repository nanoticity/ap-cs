/* 
 print triangle area title
 then define the height and base and area variables
 then after that prompt the user for those variables and assign the numbers to the variables
 then calculate and assign that to a new variable, area
 and then print out that variable
 */

import java.util.Scanner;

public class Triangle2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Area of a Triangle");
        double base, height, area;

        System.out.println("Enter in a base: ");
        base = scan.nextDouble();

        System.out.println("Enter a height: ");
        height = scan.nextDouble();
        
        area = 1.0/2 * base * height;
        System.out.println("The area is " + area);
    }
}
