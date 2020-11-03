package Tree_Que;

import DS.TreeDS.*;
import DS.StackDS.Stack;
import DS.QueueDS.Queue;
import java.util.*;



class TreeTraversals {

	public static void main(String[] args) {

		int[] a = {10, 8, 7, 9, 12, 11, 13, 20, 30, 1, 6, 99, 3, 35};

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		for (Integer i : a) bst.insert(i);
		bst.traverse();

		// bst.delete(11);
		// bst.traverse();

		// bst.delete(12);
		// bst.traverse();

		// bst.delete(8);
		// bst.traverse();

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

		System.out.print("\nRight View: ");
		rightView(bst.getRoot());
		System.out.println("\n");


		System.out.print("\nTop View: ");
		topOrBottomView(bst.getRoot(), true);
		System.out.println("\n");


		System.out.print("\nBottom View: ");
		topOrBottomView(bst.getRoot(), false);
		System.out.println("\n");


		System.out.print("\nSpiral View: ");
		spiralView(bst.getRoot());
		System.out.println("\n");


		System.out.print("\nHeight: " + height(bst.getRoot()));
		System.out.println("\n");


		System.out.print("\nDiameter: ");
		int[] op = {0};
		diameter(bst.getRoot(), op);
		System.out.println(op[0] + "\n");


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


	public static void rightView(TreeNode root) {

		if (root == null) return;

		Queue<TreeNode> q = new Queue<>();
		q.add(root);


		while (!q.isEmpty()) {

			int size = q.getSize();

			for (int i = 0; i < size; i++) {

				TreeNode tmp = q.remove();

				if (i == 0) System.out.print(tmp.data + " ");

				if (tmp.right != null) q.add(tmp.right);
				if (tmp.left != null) q.add(tmp.left);
			}
		}
	}


	public static void topOrBottomView(TreeNode root, boolean topView) {

		if (root == null) return;

		Map<Integer, TreeNode> map = new TreeMap<>();
		traverseTree(root, map, 0, 0, topView);

		for (Integer i : map.keySet()) System.out.print(map.get(i).data + " ");
	}


	public static void traverseTree(TreeNode root, Map<Integer, TreeNode> map, int x, int y, boolean topView) {

		if (topView && !map.containsKey(x)) map.put(x, root);
		if (!topView) map.put(x, root);

		if (root.left != null) traverseTree(root.left, map, x - 1, y + 1, topView);
		if (root.right != null) traverseTree(root.right, map, x + 1, y + 1, topView);
	}



	public static void spiralView(TreeNode root) {

		if (root == null) return;

		Queue<TreeNode> q = new Queue<>();
		q.add(root);

		LinkedList<TreeNode> op = new LinkedList<>();

		boolean leftToRight = true;

		while (!q.isEmpty()) {

			int size = q.getSize();

			while (size-- > 0) {

				TreeNode tmp = q.remove();

				if (leftToRight) op.add(tmp);
				else op.addFirst(tmp);

				if (tmp.left != null) q.add(tmp.left);
				if (tmp.right != null) q.add(tmp.right);
			}

			for (TreeNode t : op) System.out.print(t.data + " ");
			System.out.println();
			op.clear();
			leftToRight = !leftToRight;
		}
	}


	public static int height(TreeNode root) {

		if (root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}


	public static int diameter(TreeNode root, int[] op) {

		if (root == null) return 0;

		int leftH = diameter(root.left, op);
		int rightH = diameter(root.right, op);

		op[0] = Math.max(op[0], leftH + rightH);

		return 1 + Math.max(leftH, rightH);
	}
}
