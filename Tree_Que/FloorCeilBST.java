package Tree_Que;

import DS.TreeDS.*;

class FloorCeilBST {

	public static void main(String[] args) {

		int[] a = {10, 8, 7, 9, 12, 11, 13, 20, 30, 1, 6, 99, 3, 35};

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		for (Integer i : a) bst.insert(i);

		int[] floor = { -1};
		int[] ceil = { -1};

		findFloorCeil(bst.getRoot(), 2, floor, ceil);

		System.out.println(floor[0] + ", " + ceil[0]);
	}

	public static void findFloorCeil(TreeNode root, int key, int[] f, int[] c) {

		while (root != null) {

			int val = Integer.parseInt(root.data + "");

			if (val == key) {

				f[0] = val;
				c[0] = val;
				return;
			}

			if (val > key) {

				c[0] = val;
				root = root.left;

			} else {

				f[0] = val;
				root = root.right;
			}
		}
	}
}