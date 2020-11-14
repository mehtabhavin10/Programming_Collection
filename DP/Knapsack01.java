class Knapsack01 {

	public static void main(String[] args) {

		// int[] val = { 60, 100, 120 };
		// int[] wt = { 10, 20, 30 };
		// int w = 50;

		int[] val = {24, 18, 18, 10};
		int[] wt = {24, 10, 10, 7};
		int w = 25;

		System.out.println(findMaxProfit(val, wt, w));
	}

	static int findMaxProfit(int[] profit, int[] wt, int capacity) {

		int[][] dp = new int[profit.length + 1][capacity + 1];

		for (int i = 1; i <= profit.length; i++) {

			for (int j = 1; j <= capacity; j++) {

				if (j >= wt[i - 1]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + profit[i - 1]);
				else dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[dp.length - 1][capacity];
	}
}