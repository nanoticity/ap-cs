public class ArrayTest {
  private String[] words;
  
  public ArrayTest() {
    words = new String[5];
    words[0] = "dog";
    words[1] = "cat";
    words[2] = "giraffe";
    words[3] = "elephant";
    words[4] = "zebra";
  }
  
  public void printWords() {
    for (String s : words) {
      System.out.println(s);
    }
    System.out.println();
  }
  
  public void swapWords(int i1, int i2) {
    String temp = words[i1];
    words[i1] = words[i2];
    words[i2] = temp;
  }
}