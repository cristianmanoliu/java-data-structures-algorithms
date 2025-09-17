package io.github.cristianmanoliu.linked_lists;

public class KthNode {

  public static Node findKthNode(LinkedList list, int k) {
    if (list == null || list.getHead() == null || k < 1) {
      return null;
    }

    Node firstPointer = list.getHead();
    Node secondPointer = list.getHead();

    // Move the first pointer k nodes ahead
    for (int i = 0; i < k; i++) {
      if (firstPointer == null) {
        return null; // k is larger than the length of the list
      }
      firstPointer = firstPointer.getNext();
    }

    // Move both pointers until the first pointer reaches the end
    while (firstPointer != null) {
      firstPointer = firstPointer.getNext();
      secondPointer = secondPointer.getNext();
    }

    return secondPointer; // This is the kth node from the end
  }

}
