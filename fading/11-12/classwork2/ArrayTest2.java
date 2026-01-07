/**
 * ArrayTest2.java
 *
 * This class provides utility methods for working with integer arrays,
 * including finding an element's index, calculating the summation,
 * and doubling all elements.
 */
public class ArrayTest2 {

    /**
     * Finds the index of a target number within an array.
     *
     * @param arr The array of integers to search through.
     * @param target The number to find.
     * @return The index of the target number if found; otherwise, -1.
     */
    public int findNumberIndex(int[] arr, int target) {
        // Iterate through the array from start to end
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element matches the target
            if (arr[i] == target) {
                return i; // Return the index immediately upon finding the target
            }
        }
        // If the loop finishes without finding the target, return -1
        return -1;
    }

    /**
     * Calculates the summation (sum of all elements) of an integer array.
     *
     * @param arr The array of integers to sum.
     * @return The total sum of all elements in the array.
     */
    public int summation(int[] arr) {
        int totalSum = 0;

        // Use an enhanced for-loop (for-each) to iterate through elements
        for (int element : arr) {
            totalSum += element;
        }

        return totalSum;
    }

    /**
     * Creates and returns a new array where every value from the input array
     * is doubled.
     *
     * @param arr The input array of integers.
     * @return A new array with all original values doubled.
     */
    public int[] doubleValues(int[] arr) {
        // Create a new array of the same size as the input array
        int[] doubledArray = new int[arr.length];

        // Iterate through the input array by index
        for (int i = 0; i < arr.length; i++) {
            // Calculate the doubled value and store it in the new array
            doubledArray[i] = arr[i] * 2;
        }

        return doubledArray;
    }
}