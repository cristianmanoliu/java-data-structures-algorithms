package io.github.cristianmanoliu.datastructures.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

  @Test
  public void constructor_ShouldCreateEmptyTree() {
    BinarySearchTree bst = new BinarySearchTree();
    assertNull(bst.getRoot());
  }

  @Test
  public void contains_ShouldReturnFalseForEmptyTree() {
    BinarySearchTree bst = new BinarySearchTree();
    assertFalse(bst.contains(10));
  }

  @Test
  public void contains_ShouldFindExistingValues() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10);
    bst.insert(5);
    bst.insert(15);

    assertTrue(bst.contains(10));
    assertTrue(bst.contains(5));
    assertTrue(bst.contains(15));
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

    Node root = bst.getRoot();
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

  @Test
  public void inorderTraversal_ShouldReturnSortedValues() {
    //      10
    //     /  \
    //    5    15
    //   / \   / \
    //  3   7 12 18
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10);
    bst.insert(5);
    bst.insert(15);
    bst.insert(3);
    bst.insert(7);
    bst.insert(12);
    bst.insert(18);

    assertEquals(List.of(3, 5, 7, 10, 12, 15, 18), bst.inorder(bst.getRoot()));
  }

  @Test
  public void preorderTraversal_ShouldReturnValuesInPreorder() {
    //      10
    //     /  \
    //    5    15
    //   / \   / \
    //  3   7 12 18
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10);
    bst.insert(5);
    bst.insert(15);
    bst.insert(3);
    bst.insert(7);
    bst.insert(12);
    bst.insert(18);

    assertEquals(List.of(10, 5, 3, 7, 15, 12, 18), bst.preorder(bst.getRoot()));
  }

  @Test
  public void postorderTraversal_ShouldReturnValuesInPostorder() {
    //      10
    //     /  \
    //    5    15
    //   / \   / \
    //  3   7 12 18
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10);
    bst.insert(5);
    bst.insert(15);
    bst.insert(3);
    bst.insert(7);
    bst.insert(12);
    bst.insert(18);

    assertEquals(List.of(3, 7, 5, 12, 18, 15, 10), bst.postorder(bst.getRoot()));
  }
}
