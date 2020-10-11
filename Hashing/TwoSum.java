import java.util.*;

class TwoSum {

	public static void main(String[] args) {

		int[] ip = {0, -1, 2, -3, 1};
		int k = -2;
		getPairs(ip, k);
	}

	static void getPairs(int[] a, int k) {

		Set<Integer> set = new HashSet<>();

		for (int i : a) {

			if (set.contains(k - i)) System.out.println(i + " " + (k - i));
			set.add(i);
		}
	}
}