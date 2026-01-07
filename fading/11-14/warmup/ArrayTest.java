public class ArrayTest { 
    private int[] numbers;

    public ArrayTest(int size) {
        this.numbers = new int[size];
        for (int i = 0; i < size; i ++) {
            numbers[i] = (int) (Math.random() * 8) + 1;
        }
    }

    public void print() {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public int getSum() {
        int sum = 0;
        for (int number : numbers) { 
            sum += number;
        }
        return sum;
    }

    public int getLargest() {
        int largest = 0;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }
        }
        return largest;
    }
}
