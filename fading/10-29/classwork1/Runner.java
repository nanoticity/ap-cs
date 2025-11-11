import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        NestedLoops test = new NestedLoops();
        Scanner scanner = new Scanner(System.in);
        test.drawFilledBox();
        System.out.println("Width:");
        int width = scanner.nextInt();
        System.out.println("Height:");
        int height = scanner.nextInt();
        test.drawFilledBox(width, height);
        test.drawMultiChart();

        System.out.println("Width and Height:");
        int widthAndHeight = scanner.nextInt();
        test.drawTriangle(width);
    }
}
