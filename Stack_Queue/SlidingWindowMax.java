import java.util.*;

class SlidingWindowMax {

	public static void main(String[] args) {

		int[] ip = {9, 7, 2, 4, 6, 8, 2, 1, 5};
		int k = 3;

		getMaxOfSubArr(ip, k);
		getMax(ip, k);
	}


	// Using Deque O(N), O(K)

	static void getMaxOfSubArr(int[] a, int k) {

		Deque<Integer> q = new LinkedList<>();

		for (int i = 0; i < k; i++) {

			while (!q.isEmpty() && a[i] > a[q.peekLast()]) q.removeLast();
			q.add(i);
		}

		for (int i = k; i < a.length; i++) {

			System.out.print(a[q.peek()] + " ");

			while (!q.isEmpty() && q.peek() <= i - k) q.removeFirst();

			while (!q.isEmpty() && a[i] > a[q.peekLast()]) q.removeLast();

			q.add(i);
		}

		System.out.println(a[q.peek()]);
	}



	// Using left-right arrays O(N), O(N)

	static void getMax(int[] a, int k) {

		int n = a.length;

		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 0; i < n; i++) left[i] = (i % k == 0) ? a[i] : Math.max(a[i], left[i - 1]);

		right[n - 1] = a[n - 1];

		for (int i = n - 2; i >= 0; i--) right[i] = ((i + 1) % k == 0) ? a[i] : Math.max(a[i], right[i + 1]);


		for (int i = 0; i < n - k + 1; i++) System.out.print(Math.max(left[i + k - 1], right[i]) + " ");
	}
}