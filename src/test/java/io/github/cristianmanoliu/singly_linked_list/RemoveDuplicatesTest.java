package io.github.cristianmanoliu.singly_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {

  @Test
  public void removesDuplicatesFromListWithDuplicates() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(2);
    linkedList.append(3);

    RemoveDuplicates.removeDuplicates(linkedList);

    assertEquals(List.of(1, 2, 3), linkedList.toList());
  }

  @Test
  public void doesNotModifyListWithoutDuplicates() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);

    RemoveDuplicates.removeDuplicates(linkedList);

    assertEquals(List.of(1, 2, 3), linkedList.toList());
  }

  @Test
  public void handlesEmptyList() {
    LinkedList linkedList = new LinkedList();

    RemoveDuplicates.removeDuplicates(linkedList);

    assertTrue(linkedList.isEmpty());
  }

  @Test
  public void handlesSingleElementList() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);

    RemoveDuplicates.removeDuplicates(linkedList);

    assertEquals(List.of(1), linkedList.toList());
  }

  @Test
  public void handlesNullList() {
    LinkedList linkedList = null;

    RemoveDuplicates.removeDuplicates(linkedList);

    assertNull(linkedList);
  }
}