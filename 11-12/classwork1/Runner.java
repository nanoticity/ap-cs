import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Creates an array, takes user input, and calls the methods 
 * from ArrayTest2 to demonstrate their functionality.
 */
public class Runner {

    public static void main(String[] args) {
        // 1. Setup
        ArrayTest2 tester = new ArrayTest2();
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Create an array of size 5 with random numbers from 1 to 10
        int arraySize = 5;
        int[] numbers = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            // nextInt(10) gives 0-9, so add 1 to get 1-10
            numbers[i] = rand.nextInt(10) + 1; 
        }

        // Display the array for the user
        System.out.println("--- Array Initialized ---");
        System.out.println("The array of numbers is: " + Arrays.toString(numbers));
        System.out.println("-------------------------");

        // 2. Test findIndex (with user input)
        System.out.print("Enter a number (1-10) to search for its index: ");
        // Ensure input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // consume the non-integer input
            System.out.print("Enter a number (1-10) to search for its index: ");
        }
        int searchNumber = scanner.nextInt();
        
        int index = tester.findIndex(numbers, searchNumber);
        
        System.out.println("\n--- findIndex Result ---");
        if (index != -1) {
            System.out.println("The number " + searchNumber + " was found at index: " + index);
        } else {
            System.out.println("The number " + searchNumber + " was NOT found (Result: -1)");
        }
        System.out.println("------------------------");

        // 3. Test calculateSum
        int sumResult = tester.calculateSum(numbers);
        
        System.out.println("\n--- calculateSum Result ---");
        System.out.println("Summation of array elements: " + sumResult);
        System.out.println("---------------------------");

        // 4. Test doubleArrayElements
        int[] doubledArray = tester.doubleArrayElements(numbers);
        
        System.out.println("\n--- doubleArrayElements Result ---");
        System.out.println("Original array: " + Arrays.toString(numbers));
        System.out.println("Doubled array:  " + Arrays.toString(doubledArray));
        System.out.println("----------------------------------");

        scanner.close();
    }
}