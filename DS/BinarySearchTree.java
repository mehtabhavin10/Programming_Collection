class BinarySearchTree<T extends Comparable<T>> {

	TreeNode<T> root;

	void insert(T data) {
		root = insert(root, data);
	}

	TreeNode insert(TreeNode root, T d) {

		if (root == null) return new TreeNode(d);

		if (d.compareTo(root.data) < 0) root.left = insert(root.left, d);
		else root.right = insert(root.right, d);

		return root;
	}


	// void delete(T data) {

	// 	root = delete(root, data);
	// }

	// TreeNode delete(TreeNode root, T d) {

	// 	TreeNode par = null, tmp = root;

	// 	while(tmp != null) {

	// 		if(tmp.data.compareTo(d) == 0) break;

	// 		par = tmp;

	// 		if(d.compareTo(tmp.data) < 0) tmp = tmp.left;
	// 		else tmp = tmp.right;
	// 	}

	// 	// Node not exists
	// 	if(tmp == null) return root;

	// 	// Leaf Node
	// 	if(tmp.left == null && tmp.right == null) {

	// 		// Single Node in Tree
	// 		if(par == null) return null;

	// 		if(par.left == tmp) par.left = null;
	// 		else par.right = null;

	// 		return root;
	// 	}


	// 	// One Child
	// 	if(tmp.left == null) {

	// 		if(par == null) return root.right;

	// 		return root;
	// 	}

	// 	if(tmp.right == null) {

	// 		if(par.left)
	// 	}
	// }

	// TreeNode deleteNode(TreeNode par, TreeNode tmp, TreeNode assign) {

	// 	if(par == null) return assign

	// 	if(par.left == tmp) par.left = assign;
	// 	else par.right = assign;

	// 	return par;
	// }

	TreeNode search(TreeNode root, T data) {

		if (root == null) return null;

		if (root.data.compareTo(data) == 0) return root;

		if (data.compareTo(root.data) < 0) return search(root.left, data);
		return search(root.right, data);
	}

	void traverse() {
		preOrder(root);
	}

	void preOrder(TreeNode root) {

		if (root == null) return;

		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
}