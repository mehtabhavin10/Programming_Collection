// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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

    Set<Integer> set;

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) return false;

        set = new HashSet<>();
        return preOrder(root, k);
    }

    public boolean preOrder(TreeNode root, int k) {

        if (set.contains(k - root.val)) return true;
        set.add(root.val);

        if (root.left != null && preOrder(root.left, k)) return true;
        if (root.right != null) return preOrder(root.right, k);
        return false;
    }
}