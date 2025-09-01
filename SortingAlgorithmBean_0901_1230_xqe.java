// 代码生成时间: 2025-09-01 12:30:14
package com.example.sort;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ManagedBean for handling sorting algorithms.
 */
@ManagedBean
@RequestScoped
public class SortingAlgorithmBean {

    // List of integers to be sorted
    private List<Integer> numbers;

    // Constructor
    public SortingAlgorithmBean() {
        numbers = new ArrayList<>();
    }

    /**
     * Initializes a list of numbers with default values.
     */
    public void initNumbers() {
        numbers = new ArrayList<>(java.util.Arrays.asList(10, 5, 2, 8, 3, 1, 6, 7, 4));
    }

    /**
     * Sorts the list of numbers using the specified algorithm.
     *
     * @param algorithm The algorithm to use for sorting.
     * @return The sorted list of numbers.
     */
    public List<Integer> sortNumbers(String algorithm) {
        if (numbers == null) {
            throw new IllegalStateException("Numbers list is not initialized. Call initNumbers() first.");
        }

        List<Integer> sortedNumbers = new ArrayList<>(numbers);

        switch (algorithm) {
            case "BUBBLE":
                bubbleSort(sortedNumbers);
                break;
            case "SELECTION":
                selectionSort(sortedNumbers);
                break;
            case "INSERTION":
                insertionSort(sortedNumbers);
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm: " + algorithm);
        }

        return sortedNumbers;
    }

    /**
     * Bubble sort algorithm.
     *
     * @param list The list to sort.
     */
    private void bubbleSort(List<Integer> list) {
        boolean swapped;
        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Selection sort algorithm.
     *
     * @param list The list to sort.
     */
    private void selectionSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            Collections.swap(list, minIndex, i);
        }
    }

    /**
     * Insertion sort algorithm.
     *
     * @param list The list to sort.
     */
    private void insertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // Getters and setters
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
