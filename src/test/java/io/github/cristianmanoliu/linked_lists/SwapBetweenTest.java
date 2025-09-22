package io.github.cristianmanoliu.linked_lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SwapBetweenTest {

  @Test
  public void testSwapBetween() {
    LinkedList linkedList = new LinkedList(List.of(1, 2, 3, 4, 5));

    // Swap nodes at positions 2 and 4
    SwapBetween.swapBetween(linkedList, 2, 4);

    // Expected list after swap: 1 -> 4 -> 3 -> 2 -> 5
    assertEquals(List.of(1, 4, 3, 2, 5), linkedList.toList());
  }

}