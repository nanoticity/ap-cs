public class Runner {
  public static void main(String[] args) {

    String[] words = {
      "apple",
      "zebra",
      "orange",
      "banana",
      "grape"
    };

    ArrayTest.printArray(words);
    ArrayTest.scramble(words);
    ArrayTest.printArray(words);
    ArrayTest.sort(words);
    ArrayTest.printArray(words);
  }
}