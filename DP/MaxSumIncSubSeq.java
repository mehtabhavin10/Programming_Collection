class MaxSumIncSubSeq {

	public static void main(String[] args) {

		// int[] ip = {1, 101, 2, 3, 100, 4, 5};	// 106
		// int[] ip = {3, 4, 5, 10};				// 22
		int[] ip = {10, 3, 5, 4};					// 10

		System.out.println(getMaxSumIncSubSeq(ip));
	}

	static int getMaxSumIncSubSeq(int[] a) {

		int n = a.length;
		if (n == 0) return 0;

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) dp[i] = a[i];

		int op = dp[0];

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {

				if (a[i] > a[j]) dp[i] = Math.max(dp[i], a[i] + dp[j]);
			}

			op = Math.max(dp[i], op);
		}

		return op;
	}
}