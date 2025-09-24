package io.github.cristianmanoliu.misc;

/**
 * Class containing methods for different tree traversals.
 * <p>
 * Pre = Root first
 * <p>
 * In = Root in the middle
 * <p>
 * Post = Root last.
 */
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
    inorder(root.getLeft());
    System.out.print(root.getValue() + " ");
    inorder(root.getRight());
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
    System.out.print(root.getValue() + " ");
    preorder(root.getLeft());
    preorder(root.getRight());
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
    postorder(root.getLeft());
    postorder(root.getRight());
    System.out.print(root.getValue() + " ");
  }
}
