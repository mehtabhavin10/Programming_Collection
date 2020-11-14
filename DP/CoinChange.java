class CoinChange {

	public static void main(String[] args) {

		int[] coins = {2, 5};
		int amt = 11;

		System.out.println(minCoins(coins, amt));
		System.out.println(minCoins2(coins, amt));
	}


	// Time: O(n*m), Space: O(n*m)  ;  n - no of coins, m - value

	static int minCoins(int[] c, int m) {

		int[][] dp = new int[c.length + 1][m + 1];

		for (int i = 1; i <= m; i++) dp[0][i] = Integer.MAX_VALUE - 1;

		for (int i = 1; i <= c.length; i++) {

			for (int j = 1; j <= m; j++) {

				if (c[i - 1] <= j) dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - c[i - 1]]);
				else dp[i][j] = dp[i - 1][j];
			}
		}

		if (dp[c.length][m] == Integer.MAX_VALUE - 1) dp[c.length][m] =  -1;

		return dp[c.length][m];
	}



	// Time: O(n*m), Space: O(m)  ;  n - no of coins, m - value

	static int minCoins2(int[] c, int m) {

		int[][] dp = new int[2][m + 1];

		for (int i = 1; i <= m; i++) dp[0][i] = Integer.MAX_VALUE - 1;

		int row = 0;

		for (int i = 1; i <= c.length; i++) {

			row = 1 - row;

			for (int j = 1; j <= m; j++) {

				if (c[i - 1] <= j) dp[row][j] = Math.min(dp[1 - row][j], 1 + dp[row][j - c[i - 1]]);
				else dp[row][j] = dp[1 - row][j];
			}
		}

		if (dp[row][m] == Integer.MAX_VALUE - 1) dp[row][m] = -1;

		return dp[row][m];
	}
}