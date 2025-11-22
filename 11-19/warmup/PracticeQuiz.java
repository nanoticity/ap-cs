public class PracticeQuiz {
    public void print(int[] a) {
        for (int i : a) {
            System.out.println(i);
        }
    }

    public boolean contains(int[] a, int target) {
        for (int i : a) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

    public int getProduct(int[] a) {
        int product = a[0];
        for (int i = 1; i < a.length; i++) {
            product *= a[i];
        }
        return product;
    }

    public int getLargest(int[] a) {
        int largest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
        }
        return largest;
    }
        
}
