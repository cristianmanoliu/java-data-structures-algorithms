package io.github.cristianmanoliu.singly_linked_list;

import io.github.cristianmanoliu.singly_linked_list.LinkedList.Node;

public class SwapBetween {

  /**
   * Swaps the nodes at positions left and right (1-indexed) in-place. Preconditions: - linkedList may be null or empty (no-op) - left < right required (no-op
   * if not) Postconditions: - If both positions exist, nodes at left and right are swapped. - Head is updated if the swap involves the head. - No sublist
   * reversal is performed; exactly two nodes are swapped. Complexity: - Time: O(right), single pass to locate positions plus O(1) to swap - Space: O(1)
   */
  public static void swapBetween(LinkedList linkedList, int left, int right) {
    if (linkedList == null || linkedList.getHead() == null || left >= right || left < 1) {
      return;
    }

    Node dummy = new Node(0);
    dummy.setNext(linkedList.getHead());

    // 1) Find predecessors prevM and prevN (nodes BEFORE left and right)
    Node prevM = dummy;
    for (int i = 1; i < left; i++) {
      if (prevM.getNext() == null) { // left out of range
        return;
      }
      prevM = prevM.getNext();
    }

    Node prevN = dummy;
    for (int i = 1; i < right; i++) {
      if (prevN.getNext() == null) { // right out of range
        return;
      }
      prevN = prevN.getNext();
    }

    Node nodeM = prevM.getNext(); // left-th node
    Node nodeN = prevN.getNext(); // right-th node

    if (nodeM == null || nodeN == null) { // safety; also handles out-of-range
      return;
    }

    // 2) Handle adjacent vs non-adjacent cases
    if (prevM.getNext() == nodeM && nodeM.getNext() == nodeN) {
      // Adjacent: ... -> prevM -> nodeM -> nodeN -> tail
      // After swap: ... -> prevM -> nodeN -> nodeM -> tail
      Node tail = nodeN.getNext();
      prevM.setNext(nodeN);
      nodeN.setNext(nodeM);
      nodeM.setNext(tail);
    } else {
      // Non-adjacent: general swap
      // Before:
      //   prevM -> nodeM -> mNext
      //   prevN -> nodeN -> nNext
      // After:
      //   prevM -> nodeN -> nNext'
      //   prevN -> nodeM -> mNext'
      Node mNext = nodeM.getNext();
      Node nNext = nodeN.getNext();

      prevM.setNext(nodeN);
      nodeN.setNext(mNext);

      prevN.setNext(nodeM);
      nodeM.setNext(nNext);
    }

    // 3) Update head
    linkedList.setHead(dummy.getNext());
  }
}
