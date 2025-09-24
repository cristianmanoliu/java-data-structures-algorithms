package io.github.cristianmanoliu.datastructures.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

  @Test
  public void constructor_ShouldCreateEmptyTree() {
    BinarySearchTree bst = new BinarySearchTree();
    assertNull(bst.getRoot());
  }

  @Test
  public void insert_ShouldInsertValuesCorrectly() {
    BinarySearchTree bst = new BinarySearchTree();
    assertTrue(bst.insert(10));
    assertTrue(bst.insert(5));
    assertTrue(bst.insert(15));
    assertTrue(bst.insert(3));
    assertTrue(bst.insert(7));
    assertTrue(bst.insert(12));
    assertTrue(bst.insert(18));

    TreeNode root = bst.getRoot();
    assertNotNull(root);
    assertEquals(10, root.getValue());
    assertNotNull(root.getLeft());
    assertEquals(5, root.getLeft().getValue());
    assertNotNull(root.getRight());
    assertEquals(15, root.getRight().getValue());
    assertNotNull(root.getLeft().getLeft());
    assertEquals(3, root.getLeft().getLeft().getValue());
    assertNotNull(root.getLeft().getRight());
    assertEquals(7, root.getLeft().getRight().getValue());
    assertNotNull(root.getRight().getLeft());
    assertEquals(12, root.getRight().getLeft().getValue());
    assertNotNull(root.getRight().getRight());
    assertEquals(18, root.getRight().getRight().getValue());
  }
}
