package io.github.cristianmanoliu.datastructures.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

  private Node root;

  public Node getRoot() {
    return root;
  }

  public boolean contains(int value) {
    Node currentNode = root;
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
    Node newNode = new Node(value);
    // If tree is empty, set new node as root
    if (root == null) {
      root = newNode;
      return true;
    }

    Node currentNode = root;
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

  /**
   * Inorder traversal: Left -> Root -> Right
   *
   * @param root root of the tree
   */
  public List<Integer> inorder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> output = new ArrayList<>();
    output.addAll(inorder(root.getLeft()));
    output.add(root.getValue());
    output.addAll(inorder(root.getRight()));
    return output;
  }

  /**
   * Preorder traversal: Root -> Left -> Right
   *
   * @param root root of the tree
   */
  public List<Integer> preorder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> output = new ArrayList<>();
    output.add(root.getValue());
    output.addAll(preorder(root.getLeft()));
    output.addAll(preorder(root.getRight()));
    return output;
  }

  /**
   * Postorder traversal: Left -> Right -> Root
   *
   * @param root root of the tree
   */
  public List<Integer> postorder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> output = new ArrayList<>();
    output.addAll(postorder(root.getLeft()));
    output.addAll(postorder(root.getRight()));
    output.add(root.getValue());
    return output;
  }

}
