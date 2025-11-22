import java.util.Arrays;

/**
 * Runner.java
 *
 * This runner class demonstrates the usage of the methods in ArrayTest2.
 */
public class Runner {

    public static void main(String[] args) {
        // 1. Setup
        // Create an instance of the ArrayTest2 class to access its methods
        ArrayTest2 utility = new ArrayTest2();
        
        // Define a sample array for testing
        int[] dataArray = {10, 25, 33, 40, 5, 88, 12};
        System.out.println("--- Array Utility Demonstrations ---");
        System.out.println("Original Array: " + Arrays.toString(dataArray));
        System.out.println("------------------------------------");

        // 2. Find Index Method Test
        int target1 = 33;
        int target2 = 99;
        
        int index1 = utility.findNumberIndex(dataArray, target1);
        int index2 = utility.findNumberIndex(dataArray, target2);

        System.out.println("1. Find Index:");
        System.out.println("   Index of " + target1 + ": " + index1);
        System.out.println("   Index of " + target2 + ": " + index2);
        System.out.println();
        
        // 3. Summation Method Test
        int totalSum = utility.summation(dataArray);

        System.out.println("2. Summation:");
        System.out.println("   Sum of all elements: " + totalSum);
        System.out.println();

        // 4. Double Values Method Test
        int[] doubledArray = utility.doubleValues(dataArray);

        System.out.println("3. Double Values:");
        System.out.println("   New array with doubled values: " + Arrays.toString(doubledArray));
        System.out.println();
    }
}