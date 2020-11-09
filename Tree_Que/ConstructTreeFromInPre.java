/*

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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

	int preI;
	Map<Integer, Integer> map;

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder.length == 0) return null;

		preI = 0;
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

		return generate(preorder, 0, preorder.length - 1);
	}


	public TreeNode generate(int[] pre, int l, int h) {

		if (l > h || preI >= pre.length) return null;

		TreeNode node = new TreeNode(pre[preI]);

		int inIndex = map.get(pre[preI++]);

		node.left = generate(pre, l, inIndex - 1);
		node.right = generate(pre, inIndex + 1, h);

		return node;
	}
}