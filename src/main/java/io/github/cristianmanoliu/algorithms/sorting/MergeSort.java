package io.github.cristianmanoliu.algorithms.sorting;

public class MergeSort {

  /**
   * Sorts an array using the merge sort algorithm.
   *
   * @param array the array to be sorted
   * @return the sorted array
   */
  public static int[] mergeSort(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    int mid = array.length / 2;
    int[] left = new int[mid];
    int[] right = new int[array.length - mid];
    System.arraycopy(array, 0, left, 0, mid);
    System.arraycopy(array, mid, right, 0, array.length - mid);
    return merge(mergeSort(left), mergeSort(right));
  }

  public static int[] merge(int[] left, int[] right) {
    int[] combined = new int[left.length + right.length];
    int index = 0;
    int i = 0, j = 0;
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        combined[index++] = left[i++];
      } else {
        combined[index++] = right[j++];
      }
    }
    while (i < left.length) {
      combined[index++] = left[i++];
    }
    while (j < right.length) {
      combined[index++] = right[j++];
    }
    return combined;
  }
}
