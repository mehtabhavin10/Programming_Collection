class DriverCode {

	public static void main(String[] args) {

		int[] a = {10, 8, 7, 9, 12, 11, 13};

		AVLTree<Integer> avl = new AVLTree<>();

		for (Integer i : a) avl.insert(i);
		avl.traverse();

		avl.delete(11);
		avl.traverse();

		avl.delete(12);
		avl.traverse();

		avl.delete(8);
		avl.traverse();
	}
}