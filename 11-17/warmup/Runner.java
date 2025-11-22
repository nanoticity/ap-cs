public class Runner {
  public static void main(String[] args) {
    int[] array = new int[5];
    for (int i = 0; i < 5; i++) {
      array[i] = (int) Math.random() * 5 + 1;
    }
    Test t = new Test();
    t.print(array);
    System.out.println(t.find(array, 1));
    System.out.println(t.getSummation(array));
    System.out.println(t.getSmallest(array));

  }
}
