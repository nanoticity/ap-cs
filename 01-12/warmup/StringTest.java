public class StringTest {
  private String word; 
  public StringTest(String s) {
    word = s;
  }

  private char getFirstLetter() {
    return word.charAt(0);
  }

  private char getLastLetter() {
    return word.charAt(word.length() - 1);
  }

  public void printWordGame() {
    for(int i = 0; i < word.length(); i++) {
      if(i == 0) {
        System.out.print(getFirstLetter());
      } else if(i == word.length() - 1) {
        System.out.print(getLastLetter());
      } else {
        System.out.print("*");
      }
      if(i < word.length() - 1) {
        System.out.print(" ");
      }
    }
    System.out.println();
  }
  
  
}
