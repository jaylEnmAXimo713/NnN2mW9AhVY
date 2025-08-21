// 代码生成时间: 2025-08-21 23:40:56
package com.example.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class SortingAlgorithmService {
    
    private List<Integer> numbers;
    private List<SelectItem> sortingAlgorithms;
    private String selectedAlgorithm;
    
    // Constructor
    public SortingAlgorithmService() {
        numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);
        sortingAlgorithms = Arrays.asList(
            new SelectItem("BUBBLE", "Bubble Sort"),
            new SelectItem("INSERTION", "Insertion Sort"),
            new SelectItem("MERGE", "Merge Sort"),
            new SelectItem("QUICK", "Quick Sort")
        );
        selectedAlgorithm = sortingAlgorithms.get(0).getValue();
    }
    
    // Getters and Setters
    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    public List<SelectItem> getSortingAlgorithms() {
        return sortingAlgorithms;
    }
    
    public void setSelectedAlgorithm(String selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }
    
    public String getSelectedAlgorithm() {
        return selectedAlgorithm;
    }
    
    // Sorts the numbers using the selected algorithm
    public List<Integer> sortNumbers() {
        try {
            switch (selectedAlgorithm) {
                case "BUBBLE":
                    return bubbleSort(numbers);
                case "INSERTION":
                    return insertionSort(numbers);
                case "MERGE":
                    return mergeSort(numbers, 0, numbers.size() - 1);
                case "QUICK":
                    return quickSort(numbers, 0, numbers.size() - 1);
                default:
                    throw new IllegalArgumentException("Invalid sorting algorithm selected");
            }
        } catch (Exception e) {
            // Log the exception (e.g., using a logging framework)
            // For simplicity, just print the stack trace here
            e.printStackTrace();
            return null;
        }
    }
    
    // Bubble Sort algorithm
    private List<Integer> bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        return list;
    }
    
    // Insertion Sort algorithm
    private List<Integer> insertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        return list;
    }
    
    // Merge Sort algorithm
    private List<Integer> mergeSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(list, left, middle);
            mergeSort(list, middle + 1, right);
            merge(list, left, middle, right);
        }
        return list;
    }
    
    private void merge(List<Integer> list, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        // Create temp arrays
        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];
        
        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = list.get(left + i);
        for (int j = 0; j < n2; ++j)
            R[j] = list.get(middle + 1+ j);
        
        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                list.set(k, L[i]);
                i++;
            } else {
                list.set(k, R[j]);
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of L[] if any
        while (i < n1) {
            list.set(k, L[i]);
            i++;
            k++;
        }
        
        // Copy remaining elements of R[] if any
        while (j < n2) {
            list.set(k, R[j]);
            j++;
            k++;
        }
    }
    
    // Quick Sort algorithm
    private List<Integer> quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
        return list;
    }
    
    private int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (list.get(j) < pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}
