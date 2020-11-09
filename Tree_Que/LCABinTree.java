// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// O(n) - Assumes that the node exists

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) return null;

		if (root == p || root == q) return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) return root;

		return left != null ? left : right;
	}
}



// O(n) - also checks if nodes exists or not

class Solution {

	boolean foundA, foundB;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		foundA = false;
		foundB = false;

		TreeNode lca = find(root, p, q);

		if (foundA && foundB) return lca;
		return null;
	}

	public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {

		TreeNode tmp = null;

		if (root == null) return null;

		if (root == p) {

			foundA = true;
			tmp = root;
		}

		if (root == q) {

			foundB = true;
			tmp = root;
		}


		TreeNode left = find(root.left, p, q);
		TreeNode right = find(root.right, p, q);


		if (tmp != null) return tmp;

		if (left != null && right != null) return root;

		return left != null ? left : right;
	}