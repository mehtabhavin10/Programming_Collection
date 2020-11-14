class MaxProductSubArr {

	public static void main(String[] args) {

		// int[] ip = {6, -3, -10, 0, 2};
		// Output:   180  // The subarray is {6, -3, -10}

		// int[] ip = { -1, -3, -10, 0, 60};
		// Output:   60  // The subarray is {60}

		int[] ip = { -2, -3, 0, -2, -40};
		// Output:   80  // The subarray is {-2, -40}

		System.out.println(getMaxProd(ip));
	}

	static int getMaxProd(int[] a) {

		if (a.length == 0) return 0;

		int min = a[0], max = a[0], op = a[0];

		for (int i = 1; i < a.length; i++) {

			int x = min * a[i];
			int y = max * a[i];

			min = Math.min(a[i], Math.min(x, y));
			max = Math.max(a[i], Math.max(x, y));
			op = Math.max(op, max);
		}

		return op;
	}
}