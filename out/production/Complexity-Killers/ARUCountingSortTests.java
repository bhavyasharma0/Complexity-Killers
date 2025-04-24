import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ARUCountingSortTests {

    // Test case for sorting an array with basic elements
    @Test
    public void testBasicSorting() {
        int[] A = {10, 15, 30, 50, 10};
        int[] expected = {10, 10, 15, 30, 50};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for an array with negative values (not handled yet in the original algorithm)
    // You may need to adjust the algorithm to support negative values
    @Test
    public void testNegativeValues() {
        int[] A = {-10, -5, 0, 5, 10};
        int[] expected = {-10, -5, 0, 5, 10};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for an empty array
    @Test
    public void testEmptyArray() {
        int[] A = {};
        int[] expected = {};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for an array with one element
    @Test
    public void testSingleElementArray() {
        int[] A = {5};
        int[] expected = {5};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for an array with duplicates
    @Test
    public void testArrayWithDuplicates() {
        int[] A = {3, 3, 3, 2, 2, 1};
        int[] expected = {1, 2, 2, 3, 3, 3};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for array sorted in descending order
    @Test
    public void testDescendingArray() {
        int[] A = {50, 30, 15, 10, 10};
        int[] expected = {10, 10, 15, 30, 50};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for a large input to see if the algorithm handles big arrays
    @Test
    public void testLargeArray() {
        int[] A = new int[1000];
        for (int i = 0; i < 1000; i++) {
            A[i] = 1000 - i; // Initialize in descending order
        }
        int[] expected = new int[1000];
        for (int i = 0; i < 1000; i++) {
            expected[i] = i + 1; // Initialize in ascending order
        }

        // Measure time for ARU-Counting-sort
        long timeTaken = Sorting.measureTime(() -> ARUCountingSort.ARUCountingSort(A));
        System.out.println("Time for ARU Counting Sort: " + timeTaken + " ns");

        assertArrayEquals(expected, A);
    }

    // Test case for very large numbers
    @Test
    public void testVeryLargeNumbers() {
        int[] A = {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2};
        int[] expected = {Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for a large range of numbers
    @Test
    public void testLargeRange() {
        int[] A = {1, 1000, 500, 100, 2000, 300};
        int[] expected = {1, 100, 300, 500, 1000, 2000};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for sorted array input (edge case)
    @Test
    public void testSortedArray() {
        int[] A = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }

    // Test case for input with all identical elements
    @Test
    public void testIdenticalElements() {
        int[] A = {5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5};
        ARUCountingSort.ARUCountingSort(A);
        assertArrayEquals(expected, A);
    }
}