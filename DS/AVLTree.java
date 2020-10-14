import static java.lang.Math.max;

class AVLTree<T extends Comparable<T>> {

	TreeNode<T> root;

	void insert(T v) {
		root = insert(root, v);
	}


	TreeNode insert(TreeNode root, T v) {

		if (root == null) {

			root = new TreeNode(v);
			return root;
		}

		if (root.data.compareTo(v) > 0) root.left = insert(root.left, v);
		else root.right = insert(root.right, v);

		return balance(root);
	}


	void delete(T data) {

		root = delete(root, data);
	}


	TreeNode delete(TreeNode root, T d) {

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


	TreeNode balance(TreeNode root) {

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

	int height(TreeNode node) {

		return (node == null) ? 0 : node.height;
	}

	int balFactor(TreeNode root) {

		return height(root.left) - height(root.right);
	}

	TreeNode leftRotate(TreeNode root) {

		TreeNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;

		root.height = max(height(root.left), height(root.right)) + 1;
		newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;

		return newRoot;
	}

	TreeNode rightRotate(TreeNode root) {

		TreeNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;

		root.height = max(height(root.left), height(root.right)) + 1;
		newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;

		return newRoot;
	}


	void traverse() {
		System.out.print("\nTree: ");
		preOrder(root);
		System.out.println();
	}


	void preOrder(TreeNode root) {

		if (root == null) return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
}