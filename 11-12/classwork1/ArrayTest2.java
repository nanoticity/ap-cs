/**
 * Contains methods to perform operations on integer arrays.
 */
public class ArrayTest2 {

    /**
     * Finds the index of a specific number in an integer array.
     * * @param arr The integer array to search within.
     * @param target The number to find.
     * @return The index location of the target number, or -1 if not found.
     */
    public int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Number not found
    }

    /**
     * Calculates the summation of all numbers in an integer array.
     * * @param arr The integer array.
     * @return The sum of all elements in the array.
     */
    public int calculateSum(int[] arr) {
        int sum = 0;
        for (int number : arr) {
            sum += number;
        }
        return sum;
    }

    /**
     * Creates and returns a new array where every number from the original 
     * array is doubled (multiplied by 2).
     * * @param arr The original integer array.
     * @return A new array with all elements doubled.
     */
    public int[] doubleArrayElements(int[] arr) {
        // Create a new array with the same size as the original
        int[] doubledArr = new int[arr.length]; 

        // Populate the new array with doubled values
        for (int i = 0; i < arr.length; i++) {
            doubledArr[i] = arr[i] * 2;
        }
        return doubledArr;
    }
}