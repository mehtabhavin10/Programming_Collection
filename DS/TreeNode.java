class TreeNode<T extends Comparable<? super T>> {

	T data;
	TreeNode left, right;
	Integer height;

	TreeNode(T d) {

		data = d;
		height = 1;
	}
}