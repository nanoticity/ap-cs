public class Runner {
  public static void main(String[] args) {

    // classwork1
    int[] arr1 = { 9, 5, 3, 6, 8, 10, 7 };
    System.out.println(MyMath.binarySearch(arr1, 5, 0, arr1.length - 1));

    int[] arr2 = { 9, 10, 3, 6, 8, 5, 7 };
    System.out.println(MyMath.binarySearch(arr2, 5, 0, arr2.length - 1));

    int[] arr3 = { 3, 5, 6, 7, 8, 9, 10 };
    System.out.println(MyMath.binarySearch(arr3, 5, 0, arr3.length - 1));

    // classwork2
    int[] myArray = new int[] { 2, 4, 7, 10, 22, 33, 45, 62, 94, 100 };
    System.out.println(MyMath.binarySearch(myArray, 22, 0, myArray.length - 1));

  }
}

// ordering:
// fastest to slowest:
// quick sort
// merge sort
// insertion sort
// selection sort
// bubble sort