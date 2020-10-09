import java.util.*;

class InverionOfArr {

	public static void main(String[] args) {

		// int[] a = {8, 4, 2, 1}; 	// OP: 6
		int[] a = { 1, 20, 6, 4, 5 };	// OP: 5
		System.out.println(countInv(a, 0, a.length - 1));
	}

	static int countInv(int[] a, int l, int h) {

		int inv = 0;

		if (l < h) {

			int mid = (l + h) >>> 1;

			inv += countInv(a, l, mid);
			inv += countInv(a, mid + 1, h);
			inv += merge(a, l, mid, h);
		}

		return inv;
	}

	static int merge(int[] a, int l, int m, int h) {

		int[] left = Arrays.copyOfRange(a, l, m + 1);
		int[] right = Arrays.copyOfRange(a, m + 1, h + 1);

		int k = l, i = 0, j = 0;
		int inv = 0;

		while (i < left.length && j < right.length) {

			if (left[i] > right[j]) {

				a[k++] = right[j++];
				inv += (m + 1) - (l + i);

			} else a[k++] = left[i++];
		}

		while (i < left.length) a[k++] = left[i++];
		while (j < right.length) a[k++] = right[j++];

		return inv;
	}
}

// Time: O(nLogn), Space: O(n)