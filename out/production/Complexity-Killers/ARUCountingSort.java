import java.util.Arrays;
import java.util.Scanner;

public class ARUCountingSort {

    // Main sorting method that implements the ARU Counting Sort algorithm
    public static void ARUCountingSort(int[] A) {
        int n = A.length;

        // Handle empty input
        if (n == 0) return;

        // STEP 1: Find max value to define range
        int maxValue = Arrays.stream(A).max().getAsInt();
        int m = (int) Math.sqrt(maxValue) + 1;

        // STEP 2: Initialize chunk counters
        int numChunks = (maxValue / m) + 1;
        int[] Q = new int[numChunks];
        int[] R = new int[m];

        // Count how many values fall in each chunk
        for (int value : A) {
            int chunkIndex = value / m;
            Q[chunkIndex]++;
        }

        // Compute prefix sums for chunk placement
        int[] prefixQ = new int[numChunks];
        prefixQ[0] = 0;
        for (int i = 1; i < numChunks; i++) {
            prefixQ[i] = prefixQ[i - 1] + Q[i - 1];
        }

        // Create temporary array for sorting
        int[] temp = new int[n];

        // Sort within each chunk using remainder
        for (int chunk = 0; chunk < numChunks; chunk++) {
            Arrays.fill(R, 0);

            // Count remainders
            for (int value : A) {
                if (value / m == chunk) {
                    R[value % m]++;
                }
            }

            // Prefix sums for remainders
            int[] prefixR = new int[m];
            prefixR[0] = 0;
            for (int j = 1; j < m; j++) {
                prefixR[j] = prefixR[j - 1] + R[j - 1];
            }

            // Place elements into temp array
            for (int value : A) {
                if (value / m == chunk) {
                    int remainder = value % m;
                    int pos = prefixQ[chunk] + prefixR[remainder];
                    temp[pos] = value;
                    prefixR[remainder]++;
                }
            }
        }

        // Write back to original array
        System.arraycopy(temp, 0, A, 0, n);
    }

    // Optional: Interactive input method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] A = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        scanner.close();
        ARUCountingSort(A);
        System.out.println("Sorted Array: " + Arrays.toString(A));
    }
}