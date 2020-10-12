import java.util.*;

class SubArrWithXor {

	public static void main(String[] args) {

		int[] arr = {4, 2, 2, 6, 4};
		int m = 6;

		System.out.println(getCountSubArr(arr, m));

		arr = new int[] {5, 6, 7, 8, 9};
		m = 5;

		System.out.println(getCountSubArr(arr, m));
	}

	static int getCountSubArr(int[] a, int k) {

		Map<Integer, Integer> freq = new HashMap<>();

		int preXor = 0, op = 0;

		for (int i : a) {

			preXor ^= i;
			if (preXor == k) op++;

			op += freq.getOrDefault(preXor ^ k, 0);

			int curr = freq.getOrDefault(preXor, 0) + 1;
			freq.put(preXor, curr);
		}

		return op;
	}
}