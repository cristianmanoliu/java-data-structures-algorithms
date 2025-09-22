package io.github.cristianmanoliu.singly_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class PartitionListTest {

  @Test
  void partitionsListAroundPivotValue() {
    LinkedList linkedList = new LinkedList(List.of(1, 3, 5, 8, 5, 10, 2));

    int pivot = 5;

    PartitionList.partition(linkedList, pivot);

    assertEquals(List.of(1, 3, 2, 5, 8, 5, 10), linkedList.toList());
  }


  @Test
  void noElementsLowerThanPivot() {
    LinkedList linkedList = new LinkedList(List.of(1, 3, 5, 8, 5, 10, 2));

    int pivot = 0;

    PartitionList.partition(linkedList, pivot);

    assertEquals(List.of(1, 3, 5, 8, 5, 10, 2), linkedList.toList());
  }

  @Test
  void noElementsGreaterThanPivot() {
    LinkedList linkedList = new LinkedList(List.of(1, 3, 5, 8, 5, 10, 2));

    int pivot = 100;

    PartitionList.partition(linkedList, pivot);

    assertEquals(List.of(1, 3, 5, 8, 5, 10, 2), linkedList.toList());
  }


}