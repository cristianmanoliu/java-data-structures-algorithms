package io.github.cristianmanoliu.datastructures.linkedlist;

import io.github.cristianmanoliu.datastructures.linkedlist.LinkedList.Node;

public class PartitionList {

  public static void partition(LinkedList linkedList, int pivot) {
    if (linkedList == null || linkedList.getHead() == null) {
      return;
    }

    Node beforeStart = null, beforeEnd = null;
    Node afterStart = null, afterEnd = null;

    Node current = linkedList.getHead();
    while (current != null) {
      Node next = current.getNext();
      current.setNext(null); // detach from original list

      if (current.getValue() < pivot) {
        // Insert into end of before list
        if (beforeStart == null) {
          beforeStart = beforeEnd = current;
        } else {
          beforeEnd.setNext(current);
          beforeEnd = current;
        }
      } else {
        // Insert into end of after list
        if (afterStart == null) {
          afterStart = afterEnd = current;
        } else {
          afterEnd.setNext(current);
          afterEnd = current;
        }
      }
      current = next;
    }

    // Stitch and reset list invariants
    if (beforeStart == null) {
      // all nodes are >= pivot so no before list
      linkedList.resetFromHead(afterStart);
    } else {
      // there are some nodes < pivot
      beforeEnd.setNext(afterStart);
      linkedList.resetFromHead(beforeStart);
    }
  }
}
