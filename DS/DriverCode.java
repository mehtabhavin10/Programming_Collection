class DriverCode {

	public static void main(String[] args) {


		int[] a = {10, 8, 7, 9, 12, 11, 13};

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		for (Integer i : a) bst.insert(i);
		bst.traverse();

		bst.levelOrder();

		bst.delete(11);
		bst.traverse();

		bst.delete(12);
		bst.traverse();

		bst.delete(8);
		bst.traverse();

	}
}