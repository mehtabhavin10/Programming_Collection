class DriverCode {

	public static void main(String[] args) {


		int[] a = {45, 23, 34, 89, 56, 67, 78, 12, 90};

		Heap<Integer> minHeap = new Heap<>(true);

		for (int i : a) minHeap.add(i);

		while (!minHeap.isEmpty()) System.out.println(minHeap.remove());
	}
}