/*


https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3553/

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.



Example 1:


Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
Example 2:


Input: root = [5,1,7]
Output: [1,null,5,null,7]


Constraints:

The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000

*/
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

    TreeNode prev, newRoot;
    boolean leftMost;
    public TreeNode increasingBST(TreeNode root) {

        if (root == null) return root;
        inOrder(root);
        return newRoot;
    }

    void inOrder(TreeNode root) {

        if (root == null) return;
        inOrder(root.left);

        if (prev != null) {

            prev.left = null;
            prev.right = root;
            root.left = null;
        }

        prev = root;

        if (!leftMost) {

            newRoot = root;
            leftMost = true;
        }

        inOrder(root.right);
    }
}