class RemoveDupFromSortedArr {

	public static void main(String[] args) {

		int[] ip = {1, 2, 2, 3, 4, 4, 4, 5, 5};

		int n = removeDup(ip);

		for (int i = 0; i < n; i++) System.out.print(ip[i] + " ");
	}


	// Should be in-place in O(1) Extra Space

	static int removeDup(int[] a) {

		int n = a.length;

		if (n <= 1) return n;

		int k = 0;

		for (int i = 0; i < n - 1; i++) if (a[i] != a[i + 1]) a[k++] = a[i];
		a[k++] = a[n - 1];

		return k;
	}
}