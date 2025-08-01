// 代码生成时间: 2025-08-01 10:00:52
package com.example.sort;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collections;
import java.util.List;

/**
 * Managed bean for sorting operations.
 */
@ManagedBean
@SessionScoped
public class SortServiceBean {

    private List<Integer> numbers = List.of(5, 3, 8, 1, 4, 7, 2, 6);
    private List<Integer> sortedNumbers;

    /**
     * Sort the numbers using the bubble sort algorithm.
     * @return the sorted list of numbers.
     */
    public List<Integer> bubbleSort() {
        try {
            for (int i = 0; i < numbers.size() - 1; i++) {
                for (int j = 0; j < numbers.size() - i - 1; j++) {
                    if (numbers.get(j) > numbers.get(j + 1)) {
                        // Swap the elements
                        int temp = numbers.get(j);
                        numbers.set(j, numbers.get(j + 1));
                        numbers.set(j + 1, temp);
                    }
                }
            }
            sortedNumbers = numbers;
            return sortedNumbers;
        } catch (Exception e) {
            // Log the error and handle it appropriately
            System.err.println("Error during bubble sort: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Getters and setters for the numbers and sortedNumbers.
     */
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        return sortedNumbers;
    }

    public void setSortedNumbers(List<Integer> sortedNumbers) {
        this.sortedNumbers = sortedNumbers;
    }
}
