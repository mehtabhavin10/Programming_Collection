import java.util.*;

class DistinctNumInWindow {

	public static void main(String[] args) {

		int[] a = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;

		getDistinctCount(a, k);
	}

	static void getDistinctCount(int[] a, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		int i = 0;
		while (i < k) map.put(a[i], map.getOrDefault(a[i++], 0) + 1);

		while (i < a.length) {

			System.out.print(map.size() + " ");

			int count = map.get(a[i - k]);

			if (count == 1) map.remove(a[i - k]);
			else map.put(a[i - k], count - 1);

			map.put(a[i], map.getOrDefault(a[i++], 0) + 1);
		}

		System.out.print(map.size() + " ");
	}
}