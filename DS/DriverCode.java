class DriverCode {

	public static void main(String[] args) {

		int[] a = {10, 8, 7, 9, 12, 11, 13};

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		for (Integer i : a) bst.insert(i);
		bst.traverse();
	}
}