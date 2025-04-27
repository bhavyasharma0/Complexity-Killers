# ARU-Counting-Sort Algorithm Implementation
## Overview:

This project presents the ARU-Counting-Sort algorithm, an enhanced version of the classical Counting Sort. The ARU-Counting-Sort algorithm improves upon the original by reducing both time and space complexities, making it more efficient, especially when the range of input values (k) is large. The time complexity of the algorithm is O(n + √k), and the space complexity is O(2n + 2√k), where n represents the number of elements in the array and k is the maximum element. This variant uses quotient and remainder arrays to manage large datasets more efficiently. In this project, we have implemented the ARU-Counting-Sort algorithm in Java, tested it for correctness, and compared its performance against traditional sorting algorithms like Counting Sort, QuickSort, MergeSort, RadixSort, and others.

## Requirements:

To run the project and reproduce the results, you will need Java installed on your system. The code is compatible with Java 8 or later. Additionally, we have used JUnit 5 for testing the algorithm's correctness. If you prefer using a dependency management tool, Maven or Gradle can be utilized, although they are not strictly required for running the code.

## Setup Instructions:

To get started, you first need to clone the repository. You can do this by running the following command in your terminal:

```
git clone https://github.com/your-username/ARU-Counting-Sort.git
cd ARU-Counting-Sort
```

Once the repository is cloned, ensure that you have Java installed. You can check this by running the following command:

```
java -version
```

If Java is not installed, you can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).

Next, compile the Java code by running the following command:

```
javac ARUCountingSort.java
```

After compiling the code, you can run the ARU-Counting-Sort implementation with:

```
java ARUCountingSort
```

## Running Tests:

We have written a series of JUnit tests to validate the correctness of the ARU-Counting-Sort implementation. These tests cover various scenarios, such as sorting arrays with duplicate elements, sorted arrays, and arrays with large values.
For manual testing, if JUnit is set up in your environment, you can compile and run the tests with the following commands:

```
javac -cp .:junit-5.x.jar ARUCountingSortTests.java
java -cp .:junit-5.x.jar org.junit.platform.console.ConsoleLauncher --select-class ARUCountingSortTests
```

## Running the Benchmark:

The benchmark tests compare the performance of ARU-Counting-Sort with other well-known sorting algorithms such as Counting Sort, QuickSort, MergeSort, RadixSort, and others. The benchmark evaluates both the execution time and memory usage of each algorithm.
To run the benchmark, simply execute the `Sorting.java` file, which contains the benchmark code. This file measures the time taken and memory used by each sorting algorithm for arrays of different sizes (from 1,000 to 1,000,000 elements) and varying values of k. To start the benchmark, run:

```
java Sorting
```
The output will include the time and memory usage for each algorithm, allowing you to analyze and compare their performance. The data will be printed directly to the console.

## Reproducing the Results:

The benchmark will display results for different algorithms, showing their time and space complexities for various array sizes. For instance, the output will show the time taken in nanoseconds and the space used in bytes. This allows you to visualize how each sorting algorithm performs with different input sizes and maximum element values (k). You can use the printed data to generate graphs comparing the algorithms' performance, like time taken and memory consumption, for different array sizes.

## Limitations:

While the ARU-Counting-Sort algorithm performs well for large datasets with non-negative integers, it does have a few limitations. Most notably, ARU-Counting-Sort does not work with negative integers because it assumes non-negative values when calculating quotients and remainders. This issue can be addressed by modifying the algorithm to handle negative values. Additionally, when the number of elements, n, is smaller than the square root of the maximum element (√k), the algorithm’s performance may degrade slightly, although it still outperforms Counting Sort in most cases.

## Conclusion:

The ARU-Counting-Sort algorithm represents a significant improvement over traditional Counting Sort, offering better performance for large input ranges. Although it does have limitations, particularly with negative integers, it provides excellent sorting speed and reduced memory usage when compared to traditional sorting algorithms, especially when dealing with large datasets. This project demonstrates how theoretical improvements in algorithms can be effectively implemented and validated in real-world scenarios, and the ARU-Counting-Sort is a promising alternative for specialized sorting tasks where both time and space efficiency are crucial.

