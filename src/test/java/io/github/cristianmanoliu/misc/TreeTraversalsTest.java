package io.github.cristianmanoliu.misc;

import org.junit.jupiter.api.Test;

class TreeTraversalsTest {

  @Test
  void inorder() {
    // Sample tree structure:
    //       1
    //      / \
    //     2   3
    //    / \ / \
    //   4  5 6  7

    TreeNode root = new TreeNode(1,
        new TreeNode(2,
            new TreeNode(4, null, null),
            new TreeNode(5, null, null)),
        new TreeNode(3,
            new TreeNode(6, null, null),
            new TreeNode(7, null, null)));

    TreeTraversals traversals = new TreeTraversals();
    System.out.print("Inorder traversal: ");
    traversals.inorder(root); // Expected output: 4 2 5 1 6 3 7
  }

  @Test
  void preorder() {
    // Sample tree structure:
    //       1
    //      / \
    //     2   3
    //    / \ / \
    //   4  5 6  7

    TreeNode root = new TreeNode(1,
        new TreeNode(2,
            new TreeNode(4, null, null),
            new TreeNode(5, null, null)),
        new TreeNode(3,
            new TreeNode(6, null, null),
            new TreeNode(7, null, null)));

    TreeTraversals traversals = new TreeTraversals();
    System.out.print("Preorder traversal: ");
    traversals.preorder(root); // Expected output: 1 2 4 5 3 6 7
  }

  @Test
  void postorder() {
    // Sample tree structure:
    //       1
    //      / \
    //     2   3
    //    / \ / \
    //   4  5 6  7

    TreeNode root = new TreeNode(1,
        new TreeNode(2,
            new TreeNode(4, null, null),
            new TreeNode(5, null, null)),
        new TreeNode(3,
            new TreeNode(6, null, null),
            new TreeNode(7, null, null)));

    TreeTraversals traversals = new TreeTraversals();
    System.out.print("Postorder traversal: ");
    traversals.postorder(root); // Expected output: 4 5 2 6 7 3 1
  }
}