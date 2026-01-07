public class ArrayTest {
    private int[] numbers;

    public ArrayTest(int size) {
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9 + 1);
        }
    }

    public void print() {
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public boolean search(int target) {
        for (int i : numbers) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }


}
