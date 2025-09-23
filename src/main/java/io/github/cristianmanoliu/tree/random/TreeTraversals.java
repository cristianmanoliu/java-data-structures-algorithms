package io.github.cristianmanoliu.tree.random;

public class TreeTraversals {

  /**
   * Inorder traversal: Left -> Root -> Right
   *
   * @param root root of the tree
   */
  public void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left());
    System.out.print(root.val() + " ");
    inorder(root.right());
  }

  /**
   * Preorder traversal: Root -> Left -> Right
   *
   * @param root root of the tree
   */
  public void preorder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val() + " ");
    preorder(root.left());
    preorder(root.right());
  }

  /**
   * Postorder traversal: Left -> Right -> Root
   *
   * @param root root of the tree
   */
  public void postorder(TreeNode root) {
    if (root == null) {
      return;
    }
    postorder(root.left());
    postorder(root.right());
    System.out.print(root.val() + " ");
  }
}
