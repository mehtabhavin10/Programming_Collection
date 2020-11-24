class ProductArray {

	// Get product except self without division operator

	public static void main(String[] args) {

		int[] ip = {10, 3, 5, 6, 2};
		for (int i : getProdArray(ip)) System.out.print(i + " ");
	}

	static int[] getProdArray(int[] a) {

		int n = a.length;
		if (n == 0 || n == 1) return a;

		int[] op = new int[n];
		int tmp = 1;

		// prefix
		for (int i = 0; i < n; i++) {
			op[i] = tmp;
			tmp *= a[i];
		}

		tmp = 1;
		// suffix
		for (int i = n - 1; i >= 0; i--) {
			op[i] *= tmp;
			tmp *= a[i];
		}

		return op;
	}
}