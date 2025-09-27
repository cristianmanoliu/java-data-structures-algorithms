package io.github.cristianmanoliu.algorithms.sorting;

public class QuickSort {

  // Swap two elements in the array
  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  // QuickSort implementation
  public static void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return; // Base case: subarray has one or no elements
    }

    // Choose the pivot (always the rightmost element)
    int pivot = array[right];
    int leftPointer = left;
    int rightPointer = right - 1;

    // Partition the array around the pivot
    while (leftPointer <= rightPointer) {
      // Move the left pointer until an element greater than the pivot is found
      while (leftPointer <= rightPointer && array[leftPointer] <= pivot) {
        leftPointer++;
      }
      // Move the right pointer until an element less than the pivot is found
      while (leftPointer <= rightPointer && array[rightPointer] >= pivot) {
        rightPointer--;
      }
      // Swap elements to ensure correct partitioning
      if (leftPointer < rightPointer) {
        swap(array, leftPointer, rightPointer);
      }
    }

    // Place the pivot in its correct position
    swap(array, leftPointer, right);

    // Recursively sort the left and right subarrays
    // Exclude the pivot since it's already in the correct position
    quickSort(array, left, leftPointer - 1);
    quickSort(array, leftPointer + 1, right);
  }
}
