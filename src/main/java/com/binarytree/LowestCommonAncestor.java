package com.binarytree;

/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);

        LowestCommonAncestor solution = new LowestCommonAncestor();

        TreeNode p1 = root1.left; // Node with value 5
        TreeNode q1 = root1.right; // Node with value 1
        System.out.println("LCA of 5 and 1: " + solution.lowestCommonAncestor(root1, p1, q1).val); // Output: 3

        // Example 2
        TreeNode p2 = root1.left; // Node with value 5
        TreeNode q2 = root1.left.right.right; // Node with value 4
        System.out.println("LCA of 5 and 4: " + solution.lowestCommonAncestor(root1, p2, q2).val); // Output: 5

        // Example 3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        TreeNode p3 = root2; // Node with value 1
        TreeNode q3 = root2.left; // Node with value 2
        System.out.println("LCA of 1 and 2: " + solution.lowestCommonAncestor(root2, p3, q3).val); // Output: 1
    }
}
