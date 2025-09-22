package io.github.cristianmanoliu.linked_lists;

public class SwapBetween {

  /**
   * Swaps the nodes at positions m and n (1-indexed) in-place. Preconditions: - list may be null or empty (no-op) - m < n required (no-op if not)
   * Postconditions: - If both positions exist, nodes at m and n are swapped. - Head is updated if the swap involves the head. - No sublist reversal is
   * performed; exactly two nodes are swapped. Complexity: - Time: O(n), single pass to locate positions plus O(1) to swap - Space: O(1)
   */
  public static void swapBetween(LinkedList list, int m, int n) {
    if (list == null || list.getHead() == null || m >= n || m < 1) {
      return;
    }

    Node dummy = new Node(0);
    dummy.setNext(list.getHead());

    // 1) Find predecessors prevM and prevN (nodes BEFORE m and n)
    Node prevM = dummy;
    for (int i = 1; i < m; i++) {
      if (prevM.getNext() == null) { // m out of range
        return;
      }
      prevM = prevM.getNext();
    }

    Node prevN = dummy;
    for (int i = 1; i < n; i++) {
      if (prevN.getNext() == null) { // n out of range
        return;
      }
      prevN = prevN.getNext();
    }

    Node nodeM = prevM.getNext(); // m-th node
    Node nodeN = prevN.getNext(); // n-th node

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
    list.setHead(dummy.getNext());
  }
}
