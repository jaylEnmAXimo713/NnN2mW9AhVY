// 代码生成时间: 2025-09-07 13:55:05
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SortingService class provides methods to sort a list of integers.
 * It demonstrates the use of Java and JSF framework for sorting algorithms.
 */
public class SortingService {

    /**
     * Sorts a list of integers using Java's built-in sorting functionality.
     *
     * @param numbers The list of integers to be sorted.
     * @return The sorted list of integers.
     */
    public List<Integer> sortNumbers(List<Integer> numbers) {
        // Check for null argument
        if (numbers == null) {
            throw new IllegalArgumentException("Input list cannot be null.");
        }

        // Create a new list to avoid modifying the original list
        List<Integer> sortedNumbers = new ArrayList<>(numbers);

        // Sort the list using Collections.sort
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }

    /**
     * Main method to test the sorting functionality.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SortingService service = new SortingService();

        // Example list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(8);

        try {
            List<Integer> sortedNumbers = service.sortNumbers(numbers);
            System.out.println("Sorted numbers: " + sortedNumbers);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
