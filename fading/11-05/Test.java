public class Test {
  public void randomCount() {
    int randomNum = (int) Math.random()*10+10;
    for (int i = 1; i <= randomNum; i++) {
      System.out.println(i);
    }
  }

  public void randomSquare() {
    int width = (int) Math.random() * 5 + 5;
    int height = (int) Math.random() * 5 + 5;

    for (int i = 0; i <= height; i++) {
      for (int j = 0; j <= width; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
}
