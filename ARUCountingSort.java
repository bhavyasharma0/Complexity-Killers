import java.util.Arrays;
import java.util.Scanner;

public class ARUCountingSort {

    // Main sorting method that implements the ARU Counting Sort algorithm
    public static void ARUCountingSort(int[] A) {
        // Get the length of the input array
        int n = A.length;

        // STEP 1: Find the maximum value in the array to determine our range
        // We need this to calculate our chunk size (m)
        int maxValue = Arrays.stream(A).max().getAsInt();

        // Calculate chunk size (m) as square root of max value
        // We add 1 to handle cases where √maxValue is not a whole number
        int m = (int) Math.sqrt(maxValue) + 1;

        // STEP 2: Initialize our counting arrays
        // Q[] will count how many numbers fall into each chunk
        int numChunks = (maxValue / m) + 1;
        int[] Q = new int[numChunks];

        // STEP 3: First counting pass - count elements in each chunk
        for (int i = 0; i < n; i++) {
            // Calculate which chunk the current number belongs to
            int quotient = A[i] / m;
            Q[quotient]++;  // Increment count for this chunk
        }

        // Calculate prefix sums for Q array
        // This will help us know where each chunk starts in the final sorted array
        int[] prefixQ = new int[numChunks];
        prefixQ[0] = 0;  // First chunk starts at position 0
        for (int i = 1; i < numChunks; i++) {
            // Each chunk starts where the previous one ended
            prefixQ[i] = prefixQ[i - 1] + Q[i - 1];
        }

        // Create a temporary array to build our sorted result
        int[] temp = new int[n];
        // R array will count remainders within each chunk
        int[] R = new int[m];

        // STEP 4: Sort within each chunk using remainders
        for (int chunk = 0; chunk < numChunks; chunk++) {
            // Reset remainder counts for each new chunk
            Arrays.fill(R, 0);

            // Count how many numbers have each remainder in this chunk
            for (int j = 0; j < n; j++) {
                if (A[j] / m == chunk) {
                    int remainder = A[j] % m;
                    R[remainder]++;
                }
            }

            // Calculate prefix sums for remainders in this chunk
            // This tells us where each remainder group starts within the chunk
            int[] prefixR = new int[m];
            prefixR[0] = 0;  // First remainder starts at chunk's start position
            for (int j = 1; j < m; j++) {
                prefixR[j] = prefixR[j - 1] + R[j - 1];
            }

            // Place elements in their correct positions in the temp array
            for (int j = 0; j < n; j++) {
                if (A[j] / m == chunk) {
                    int remainder = A[j] % m;
                    // Calculate final position: chunk start + remainder offset
                    temp[prefixQ[chunk] + prefixR[remainder]] = A[j];
                    // Move to next position for this remainder
                    prefixR[remainder]++;
                }
            }
        }

        // STEP 5: Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(temp));
    }

    // Main method to handle user input and test the sorting algorithm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get array size from user
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Create array of given size
        int[] A = new int[n];

        // Get array elements from user
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Close scanner to prevent resource leak
        scanner.close();

        // Call our sorting algorithm
        ARUCountingSort(A);
    }
}