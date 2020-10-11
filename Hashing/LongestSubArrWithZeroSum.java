import java.util.*;

class LongestSubArrWithZeroSum {

	public static void main(String[] args) {

		int[] ip = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println(getLongSubArr(ip));
	}

	static int getLongSubArr(int[] a) {

		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, op = 0;

		for (int i = 0; i < a.length; i++) {

			sum += a[i];

			if (a[i] == 0 && op == 0) op = 1;

			if (sum == 0) op = i + 1;

			int index = map.getOrDefault(sum, -1);

			if (index != -1) op = Math.max(op, i - index);
			else map.put(sum, i);
		}
		return op;
	}
}