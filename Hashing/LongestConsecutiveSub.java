import java.util.*;

class LongestConsecutiveSub {

	public static void main(String[] args) {

		int[] ip = { 1, 9, 3, 10, 4, 20, 2 };
		System.out.println(lcs(ip));
	}

	static int lcs(int[] a) {

		Set<Integer> set = new HashSet<>();
		int op = 0;

		for (int i : a) set.add(i);

		for (int i : a) {

			if (!set.contains(i - 1)) {

				int tmp = 1;
				while (set.contains(++i)) tmp++;
				op = Math.max(op, tmp);
			}
		}

		return op;
	}
}