package io.github.cristianmanoliu.datastructures.tree;

public class BinarySearchTree {

  private TreeNode root;

  public TreeNode getRoot() {
    return root;
  }

  public boolean insert(int value) {
    TreeNode newNode = new TreeNode(value);
    if (root == null) {
      root = newNode;
      return true;
    }

    TreeNode currentNode = root;
    while (true) {
      if (value < currentNode.getValue()) {
        // Go left
        if (currentNode.getLeft() == null) {
          // Left is empty, insert here
          currentNode.setLeft(newNode);
          return true;
        }
        currentNode = currentNode.getLeft();
      } else if (value > currentNode.getValue()) {
        // Go right
        if (currentNode.getRight() == null) {
          // Right is empty, insert here
          currentNode.setRight(newNode);
          return true;
        }
        currentNode = currentNode.getRight();
      } else {
        // Value already exists in the tree
        return false;
      }
    }
  }

}
