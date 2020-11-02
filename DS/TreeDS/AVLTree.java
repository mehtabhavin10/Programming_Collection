package DS.TreeDS;

import static java.lang.Math.max;


public class AVLTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public void insert(T v) {
		root = insert(root, v);
	}


	private TreeNode insert(TreeNode root, T v) {

		if (root == null) {

			root = new TreeNode(v);
			return root;
		}

		if (root.data.compareTo(v) > 0) root.left = insert(root.left, v);
		else root.right = insert(root.right, v);

		return balance(root);
	}


	public void delete(T data) {

		root = delete(root, data);
	}


	private TreeNode delete(TreeNode root, T d) {

		if (root == null) return null;

		if (root.data.compareTo(d) == 0) {

			if (root.left == null && root.right == null) return null;
			else if (root.left == null) return root.right;
			else if (root.right == null) return root.left;
			else {

				TreeNode tmp = root.left, par = null;

				while (tmp.right != null) {
					par = tmp;
					tmp = tmp.right;
				}

				if (par != null) {

					par.right = tmp.left;
					tmp.left = root.left;
					tmp.right = root.right;

				} else tmp.right = root.right;

				return tmp;
			}
		}

		if (root.data.compareTo(d) > 0) root.left = delete(root.left, d);
		else root.right = delete(root.right, d);

		return balance(root);
	}


	private TreeNode balance(TreeNode root) {

		root.height = max(height(root.left), height(root.right)) + 1;


		if (balFactor(root) > 1) {

			if (balFactor(root.left) == 1) {

				// LL

				return leftRotate(root);


			} else {

				// LR

				root.left = rightRotate(root.left);
				return leftRotate(root);

			}

		} else if (balFactor(root) < -1) {

			if (balFactor(root.right) == -1) {

				// RR

				return rightRotate(root);

			} else {

				// RL

				root.right = leftRotate(root.right);
				return rightRotate(root);
			}
		}

		return root;
	}

	private int height(TreeNode node) {

		return (node == null) ? 0 : node.height;
	}

	private int balFactor(TreeNode root) {

		return height(root.left) - height(root.right);
	}

	private TreeNode leftRotate(TreeNode root) {

		TreeNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;

		root.height = max(height(root.left), height(root.right)) + 1;
		newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;

		return newRoot;
	}

	private TreeNode rightRotate(TreeNode root) {

		TreeNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;

		root.height = max(height(root.left), height(root.right)) + 1;
		newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;

		return newRoot;
	}


	public void traverse() {
		System.out.print("\nTree: ");
		preOrder(root);
		System.out.println();
	}


	private void preOrder(TreeNode root) {

		if (root == null) return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
}