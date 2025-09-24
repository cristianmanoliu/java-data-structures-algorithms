package io.github.cristianmanoliu.datastructures.linkedlist;

import io.github.cristianmanoliu.datastructures.linkedlist.LinkedList.Node;

public class KthNode {

  public static Node findKthNode(LinkedList linkedList, int k) {
    if (linkedList == null || linkedList.getHead() == null || k < 1) {
      return null;
    }

    Node firstPointer = linkedList.getHead();
    Node secondPointer = linkedList.getHead();

    // Move the first pointer k nodes ahead
    for (int i = 0; i < k; i++) {
      if (firstPointer == null) {
        return null; // k is larger than the length of the linkedList
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
