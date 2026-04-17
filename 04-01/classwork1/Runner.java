public class Runner {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();

        myMath.countDown(5);
        myMath.countUp(10);
        System.out.println(myMath.factorial(5));
        System.out.println(myMath.summation(5));
    }
}
