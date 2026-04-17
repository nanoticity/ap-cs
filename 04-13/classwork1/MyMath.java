public class MyMath {

  public static int binarySearch(int[] array, int value, int start, int end) {
    if (start > end) {
      return -1;
    }
    int middle = (start + end) / 2;
    if (array[middle] == value) {
      return middle;
    } else if (array[middle] > value) {
      return binarySearch(array, value, start, middle - 1);
    } else {
      return binarySearch(array, value, middle + 1, end);
    }
  }

}