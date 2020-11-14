class RodCutting {

	public static void main(String[] args) {

		int[] ip = {1, 5, 8, 9, 10, 17, 17, 20};
		// int[] ip = {1, 5, 8, 9};
		System.out.println(getMaxProfit(ip, ip.length));
		System.out.println(getMaxProfit2(ip, ip.length));
	}


	// Recursive: O(2^n)

	static int getMaxProfit(int[] price, int n) {

		if (n == 0) return 0;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) max = Math.max(max, price[i] + getMaxProfit(price, n - i - 1));
		return max;
	}



	// DP: O(n^2), Space: O(n)

	static int getMaxProfit2(int[] price, int n) {

		if (n == 0) return 0;

		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {

			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) max = Math.max(max, price[j] + dp[i - j - 1]);
			dp[i] = max;
		}

		return dp[n];
	}
}