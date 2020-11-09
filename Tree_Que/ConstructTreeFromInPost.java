/*

https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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

    Map<Integer, Integer> map;
    int postI;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0) return null;

        postI = postorder.length - 1;
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return constructTree(postorder, 0, inorder.length - 1);
    }


    TreeNode constructTree(int[] post, int start, int end) {

        if (start > end || postI < 0) return null;

        TreeNode root = new TreeNode(post[postI]);

        int inI = map.get(post[postI--]);


        root.right = constructTree(post, inI + 1, end);
        root.left = constructTree(post, start, inI - 1);

        return root;
    }


}