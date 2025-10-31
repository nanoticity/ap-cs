public class Runner {
    public static void main(String[] args) {
        ForTest2 test = new ForTest2();
        System.out.println("printCount1(10):");
        test.printCount1(10);
        int sum1 = test.getSum1(5);
        System.out.println("getSum1(5): " + sum1);
        System.out.println("printCount2(3, 10):");
        test.printCount2(3, 10);
        int sum2 = test.getSum2(5);
        System.out.println("getSum2(5): " + sum2);
    }
}
