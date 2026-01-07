public class Test {
  public void print(int[] array) {
    for (int i : array) {
      System.out.println(i);
    }
  }
  
  public int find(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public int getSummation(int[] array) {
    int total = 0;
    for (int i : array) {
      total += i;
    }
    return total;
  }

  public int getSmallest(int[] array) {
    int smallest = array[0];
    for (int i : array) {
      if (i < smallest) {
        smallest = i;
      }
    }
    return smallest;
  }
}
