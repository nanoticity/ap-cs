public class MyMath {
    public void countDown(int number) {
        System.out.println(number);

        if (number > 0) {
            countDown(number - 1);
        }
    }

    public void countUp(int number) {
        if (number <= 0) {
            return;
        }

        countUpHelper(1, number);
    }

    private void countUpHelper(int current, int target) {
        System.out.println(current);

        if (current < target) {
            countUpHelper(current + 1, target);
        }
    }

    public int factorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public int summation(int number) {
        if (number == 1) {
            return 1;
        }

        return number + summation(number - 1);
    }
}
