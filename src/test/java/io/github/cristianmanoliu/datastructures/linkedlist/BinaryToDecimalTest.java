package io.github.cristianmanoliu.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryToDecimalTest {

  @Test
  public void convertsBinaryToDecimal() {
    LinkedList binaryList = new LinkedList();
    binaryList.append(1);
    binaryList.append(0);
    binaryList.append(1); // Represents binary 101

    int decimalValue = BinaryToDecimal.convert(binaryList);

    assertEquals(5, decimalValue);
  }

}