package io.github.cristianmanoliu.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class QuickSortTest {

  @Test
  public void sort_ShouldSortArray() {
    int[] array = {4, 2, 7, 1, 3, 5, 6};
    QuickSort.quickSort(array, 0, array.length - 1);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, array);
  }
}