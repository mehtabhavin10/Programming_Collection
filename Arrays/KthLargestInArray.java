import java.util.*;

class KthLargestInArray {

	public static void main(String[] args) {

		// int[] ip = {3, 2, 1, 5, 6, 4};
		// int k = 2;
		// op: 5

		int[] ip = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int k = 4;
		// op: 4

		System.out.println(findKthLargest(ip, k));
	}

	public static int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i : nums) {

			minHeap.add(i);
			if (minHeap.size() > k) minHeap.remove();
		}

		return minHeap.remove();
	}
}