package Tree_Que;

import DS.TreeDS.*;
import DS.StackDS.Stack;
import DS.QueueDS.Queue;



class TreeTraversals {

	public static void main(String[] args) {

		int[] a = {10, 8, 7, 9, 12, 11, 13, 20, 30, 1, 6, 99, 3};

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		for (Integer i : a) bst.insert(i);
		bst.traverse();

		bst.delete(11);
		bst.traverse();

		bst.delete(12);
		bst.traverse();

		bst.delete(8);
		bst.traverse();

		System.out.print("\ninOrderRec: ");
		inOrderRec(bst.getRoot());
		System.out.println("\n");


		System.out.print("\ninOrderItr: ");
		inOrderItr(bst.getRoot());
		System.out.println("\n");


		System.out.print("\npreOrderItr: ");
		preOrderItr(bst.getRoot());
		System.out.println("\n");


		System.out.print("\npostOrderItr: ");
		postOrderItr(bst.getRoot());
		System.out.println("\n");

		System.out.print("\nLeft View: ");
		leftView(bst.getRoot());
		System.out.println("\n");

	}

	public static void inOrderRec(TreeNode root) {

		if (root == null) return;

		inOrderRec(root.left);
		System.out.print(root.data + " ");
		inOrderRec(root.right);
	}


	public static void inOrderItr(TreeNode root) {

		if (root == null) return;

		Stack<TreeNode> stk = new Stack<>();
		TreeNode tmp = root;

		while (tmp != null || !stk.isEmpty()) {

			while (tmp != null) {

				stk.push(tmp);
				tmp = tmp.left;
			}

			tmp = stk.pop();
			System.out.print(tmp.data + " ");
			tmp = tmp.right;
		}
	}


	public static void preOrderItr(TreeNode root) {

		if (root == null) return;

		Stack<TreeNode> stk = new Stack<>();
		stk.push(root);

		while (!stk.isEmpty()) {

			TreeNode tmp = stk.pop();

			System.out.print(tmp.data + " ");

			if (tmp.right != null) stk.push(tmp.right);
			if (tmp.left != null) stk.push(tmp.left);
		}
	}


	public static void postOrderItr(TreeNode root) {

		if (root == null) return;

		Stack<TreeNode> stk = new Stack<>();
		Stack<TreeNode> stk2 = new Stack<>();
		stk.push(root);

		while (!stk.isEmpty()) {

			TreeNode tmp = stk.pop();
			stk2.push(tmp);

			if (tmp.left != null) stk.push(tmp.left);
			if (tmp.right != null) stk.push(tmp.right);
		}

		while (!stk2.isEmpty()) System.out.print(stk2.pop().data + " ");
	}


	public static void leftView(TreeNode root) {

		if (root == null) return;

		Queue<TreeNode> q = new Queue<>();
		q.add(root);


		while (!q.isEmpty()) {

			int size = q.getSize();

			for (int i = 0; i < size; i++) {

				TreeNode tmp = q.remove();

				if (i == 0) System.out.print(tmp.data + " ");


				if (tmp.left != null) q.add(tmp.left);
				if (tmp.right != null) q.add(tmp.right);
			}
		}
	}
}