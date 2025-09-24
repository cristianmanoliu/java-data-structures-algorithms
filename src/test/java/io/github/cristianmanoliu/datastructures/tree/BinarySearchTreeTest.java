package io.github.cristianmanoliu.datastructures.tree;

import static org.junit.jupiter.api.Assertions.assertNull;

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
    bst.insert(10);
    bst.insert(5);
    bst.insert(15);
    bst.insert(3);
    bst.insert(7);
    bst.insert(12);
    bst.insert(18);

    TreeNode root = bst.getRoot();
    assert root != null;
    assert root.getValue() == 10;
    assert root.getLeft() != null && root.getLeft().getValue() == 5;
    assert root.getRight() != null && root.getRight().getValue() == 15;
    assert root.getLeft().getLeft() != null && root.getLeft().getLeft().getValue() == 3;
    assert root.getLeft().getRight() != null && root.getLeft().getRight().getValue() == 7;
    assert root.getRight().getLeft() != null && root.getRight().getLeft().getValue() == 12;
    assert root.getRight().getRight() != null && root.getRight().getRight().getValue() == 18;
  }

}