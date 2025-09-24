package io.github.cristianmanoliu.datastructures.tree;

public class BinarySearchTree {

  private TreeNode root;

  public TreeNode getRoot() {
    return root;
  }

  public boolean contains(int value) {
    TreeNode currentNode = root;
    while (currentNode != null) {
      if (value < currentNode.getValue()) {
        currentNode = currentNode.getLeft();
      } else if (value > currentNode.getValue()) {
        currentNode = currentNode.getRight();
      } else {
        return true; // Value found
      }
    }
    return false; // Value not found
  }

  public boolean insert(int value) {
    TreeNode newNode = new TreeNode(value);
    // If tree is empty, set new node as root
    if (root == null) {
      root = newNode;
      return true;
    }

    TreeNode currentNode = root;
    // Traverse the tree to find the correct insertion point
    while (true) {
      if (value < currentNode.getValue()) {
        // Go left
        if (currentNode.getLeft() == null) {
          // Left is empty, insert here
          currentNode.setLeft(newNode);
          return true;
        }
        // Not empty, keep going left
        currentNode = currentNode.getLeft();
      } else if (value > currentNode.getValue()) {
        // Go right
        if (currentNode.getRight() == null) {
          // Right is empty, insert here
          currentNode.setRight(newNode);
          return true;
        }
        // Not empty, keep going right
        currentNode = currentNode.getRight();
      } else {
        // Value already exists in the tree
        return false;
      }
    }
  }

}
