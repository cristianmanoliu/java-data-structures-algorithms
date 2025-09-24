package io.github.cristianmanoliu.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SwapNodesInPairsTest {

  @Test
  public void testSwapNodesInPairsForOdd() {
    LinkedList linkedList = new LinkedList(List.of(1, 2, 3, 4, 5));

    // Swap nodes in pairs
    SwapNodesInPairs.swapPairs(linkedList);

    // Expected list after swap: 2 -> 1 -> 4 -> 3 -> 5
    assertEquals(List.of(2, 1, 4, 3, 5), linkedList.toList());
  }

  @Test
  public void testSwapNodesInPairsForEven() {
    LinkedList linkedList = new LinkedList(List.of(1, 2, 3, 4, 5, 6));

    // Swap nodes in pairs
    SwapNodesInPairs.swapPairs(linkedList);

    // Expected list after swap: 2 -> 1 -> 4 -> 3 -> 6 -> 5
    assertEquals(List.of(2, 1, 4, 3, 6, 5), linkedList.toList());
  }

}