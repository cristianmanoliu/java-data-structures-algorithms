package io.github.cristianmanoliu.linked_lists;

public class PartitionList {

  public static void partition(LinkedList list, int x) {
    if (list == null || list.getHead() == null) {
      return;
    }

    Node beforeStart = null, beforeEnd = null;
    Node afterStart = null, afterEnd = null;

    Node current = list.getHead();
    while (current != null) {
      Node next = current.getNext();
      current.setNext(null); // detach from original list

      if (current.getValue() < x) {
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
      // all nodes are >= x so no before list
      list.resetFromHead(afterStart);
    } else {
      // there are some nodes < x
      beforeEnd.setNext(afterStart);
      list.resetFromHead(beforeStart);
    }
  }
}
