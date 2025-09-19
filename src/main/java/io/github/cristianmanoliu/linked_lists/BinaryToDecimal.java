package io.github.cristianmanoliu.linked_lists;

public class BinaryToDecimal {

  public static int convert(LinkedList list) {
    if (list == null || list.getHead() == null) {
      return 0;
    }

    int decimalValue = 0;
    Node current = list.getHead();
    // Traverse the linked list from head to tail
    while (current != null) {
      // Calculate the decimal value using bitwise operations
      // The left shift ensures previous bits are moved left one position, making space for the next bit.
      // The OR ensures the next bit is correctly placed at the least significant position.
      decimalValue = (decimalValue << 1) | current.getValue();
      current = current.getNext();
    }

    return decimalValue;
  }

}
