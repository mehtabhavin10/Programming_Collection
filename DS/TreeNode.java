class TreeNode<T extends Comparable<? super T>> {

	T data;
	TreeNode left, right;

	TreeNode(T d) {

		data = d;
	}
}