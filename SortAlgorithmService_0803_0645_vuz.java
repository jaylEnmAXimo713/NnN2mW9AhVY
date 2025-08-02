// 代码生成时间: 2025-08-03 06:45:47
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Service class for sorting algorithms implementation using JSF framework.
 * This class provides methods to sort lists of integers using different algorithms.
 */
public class SortAlgorithmService {

    /**
     * Sorts a list of integers using Java's built-in Collections.sort method.
     *
     * @param numbers List of integers to be sorted.
     * @return A sorted list of integers.
     */
    public List<Integer> sortUsingCollections(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("The list of numbers cannot be null");
        }

        Collections.sort(numbers);
        return numbers;
    }

    /**
     * Sorts a list of integers using Java's built-in Arrays.sort method.
     *
     * @param numbers Array of integers to be sorted.
     * @return A sorted array of integers.
     */
    public Integer[] sortUsingArrays(Integer[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("The array of numbers cannot be null");
        }

        Arrays.sort(numbers);
        return numbers;
    }

    /**
     * Example of a simple bubble sort algorithm.
     *
     * @param numbers Array of integers to be sorted.
     * @return A sorted array of integers.
     */
    public Integer[] bubbleSort(Integer[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("The array of numbers cannot be null");
        }

        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swap numbers[j] and numbers[j + 1]
                    Integer temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }

    // Additional sorting methods can be added here.

    // Main method for testing purposes.
    public static void main(String[] args) {
        SortAlgorithmService service = new SortAlgorithmService();

        // Testing with Collections.sort
        List<Integer> numbersList = Arrays.asList(5, 3, 8, 1, 6);
        try {
            System.out.println("Sorted list using Collections.sort: " + service.sortUsingCollections(numbersList));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Testing with Arrays.sort
        Integer[] numbersArray = {5, 3, 8, 1, 6};
        try {
            System.out.println("Sorted array using Arrays.sort: " + Arrays.toString(service.sortUsingArrays(numbersArray)));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Testing with bubble sort
        try {
            System.out.println("Sorted array using bubble sort: " + Arrays.toString(service.bubbleSort(numbersArray)));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
