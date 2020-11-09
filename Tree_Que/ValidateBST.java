// https://leetcode.com/problems/validate-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) return true;

        return inOrder(root);
    }

    public boolean inOrder(TreeNode node) {

        if (node.left != null && !inOrder(node.left)) return false;
        if (node.val <= prev) return false;
        prev = node.val;
        if (node.right != null) return inOrder(node.right);
        return true;
    }
}