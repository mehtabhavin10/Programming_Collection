import java.util.*;

class FindDuplicates {

	public static void main(String[] args) {

		// int[] ip = {0, 4, 3, 2, 7, 8, 2, 3, 1};
		int[] ip = {1, 1, 2, 2, 4};
		findDup(ip);
	}

	static void findDup(int[] a) {

		for (int i : a) a[i % a.length] += a.length;
		for (int i : a) if (i >= 2 * a.length) System.out.println((i - (2 * a.length)));
	}
}