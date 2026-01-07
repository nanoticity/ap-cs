public class Runner {
    public static void main(String[] args) {
        PracticeQuiz pq = new PracticeQuiz();
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 4 + 1);
        }

        pq.print(numbers);
        System.out.println(pq.contains(numbers, 3));
        System.out.println(pq.getProduct(numbers));
        System.out.println(pq.getLargest(numbers));
    }
}