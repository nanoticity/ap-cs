public class Runner {
    public static void main(String[] args) {
        ForTest test = new ForTest();

        test.printCount();
        test.printCount(10);
        test.printCount(5, 20);

        int result = test.getFactorial(5);
        System.out.println("Factorial of 5: " + result);

        test.drawBox();
    }
}