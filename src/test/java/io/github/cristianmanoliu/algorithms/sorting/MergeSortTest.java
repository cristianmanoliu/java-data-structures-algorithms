package io.github.cristianmanoliu.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  public void mergeSort_ShouldSortArray() {
    int[] array = {38, 27, 43, 3, 9, 82, 10};
    int[] expected = {3, 9, 10, 27, 38, 43, 82};
    assertArrayEquals(expected, MergeSort.mergeSort(array));
  }

  @Test
  void merge() {
    int[] left = {1, 3, 5};
    int[] right = {2, 4, 6};
    int[] expected = {1, 2, 3, 4, 5, 6};
    assertArrayEquals(expected, MergeSort.merge(left, right));
  }
}