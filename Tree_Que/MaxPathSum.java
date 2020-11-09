package Tree_Que;

import DS.TreeDS.*;

class MaxPathSum {

	public static void main(String[] args) {

		int[] a = { -10, -9, 20, 15, 7}; // Ans: 42

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		for (Integer i : a) bst.insert(i);

		System.out.println(getMaxPathSum(bst.getRoot()));
	}


	public static int getMaxPathSum(TreeNode root) {

		if (root == null) return 0;
		int[] op = {0};
		traverse(root, op);
		return op[0];
	}

	public static int traverse(TreeNode root, int[] op) {

		if (root == null) return 0;

		int left = traverse(root.left, op);
		int right = traverse(root.right, op);

		int rootVal = Integer.parseInt(root.data + "");

		int tmp = Math.max(Math.max(left, right) + rootVal, rootVal);

		op[0] = Math.max(op[0], Math.max(tmp, left + right + rootVal));

		return tmp;
	}
}