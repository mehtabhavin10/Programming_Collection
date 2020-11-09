// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/


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
    public void flatten(TreeNode root) {

        if (root == null) return;

        Stack<TreeNode> stk = new Stack<>();

        while (root != null || !stk.isEmpty()) {

            if (root.right != null) stk.push(root.right);
            if (root.left != null) root.right = root.left;
            else if (!stk.isEmpty()) root.right = stk.pop();

            root.left = null;
            root = root.right;
        }
    }
}