/*

1. Find largest index i, such that A[i] > A[i+1]
	If no found, then there is no prev permutation possible
2. Find largest index j, such that A[j] is maximum number smaller than A[i]
3. Swap A[i], A[j]

*/


class PrevPerm {

	public static void main(String[] args) {

		// int[] ip = {3, 2, 1};		// [3,1,2]
		// int[] ip = {1, 1, 5};		// [1,1,5]
		// int[] ip = {1, 9, 4, 6, 7};	// [1,7,4,6,9]
		int[] ip = {3, 1, 1, 3};	// [1,3,1,3]

		for (int i : findPrevPerm(ip)) System.out.print(i + " ");
	}


	static int[] findPrevPerm(int[] a) {

		int n = a.length;

		int i = n - 2, l = 0, h = 0;

		while (i >= 0 && a[i] <= a[i + 1]) i--;

		if (i < 0) return a;
		l = i;
		h = i + 1;

		for (i = l + 1; i < n; i++) if (a[i] > a[h] && a[i] < a[l]) h = i;

		int tmp = a[l];
		a[l] = a[h];
		a[h] = tmp;

		return a;
	}

}