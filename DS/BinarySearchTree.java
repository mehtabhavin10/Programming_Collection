class BinarySearchTree<T extends Comparable<T>> {

	TreeNode<T> root;

	void insert(T data) {
		root = insert(root, data);
	}

	TreeNode insert(TreeNode root, T d) {

		if (root == null) return new TreeNode(d);

		if (root.data.compareTo(d) > 0) root.left = insert(root.left, d);
		else root.right = insert(root.right, d);

		return root;
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

		return root;
	}


	TreeNode search(TreeNode root, T data) {

		if (root == null) return null;

		if (root.data.compareTo(data) == 0) return root;

		if (root.data.compareTo(data) > 0) return search(root.left, data);
		return search(root.right, data);
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