class EditDistance {

	public static void main(String[] args) {

		// String s1 = "sunday";
		// String s2 = "saturday";

		// String s1 = "horse";
		// String s2 = "ros";

		String s1 = "intention";
		String s2 = "execution";

		System.out.println(getMinDistance(s1, s2));
		System.out.println(getMinDistance2(s1, s2));
		System.out.println(getMinDistance3(s1, s2));
	}


	// Time: O(n*m), Space: O(n*m) - BottomUp DP

	static int getMinDistance(String a, String b) {


		int n = a.length(), m = b.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = n; i >= 0; i--) {

			for (int j = m; j >= 0; j--) {

				if (i == n || j == m) dp[i][j] = (i == n ? m - j : n - i);
				else if (a.charAt(i) == b.charAt(j)) dp[i][j] = dp[i + 1][j + 1];
				else dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j]));
			}
		}

		return dp[0][0];
	}



	// Time: O(n*m), Space: O(n*m) - TopDown DP

	static int getMinDistance2(String a, String b) {


		int n = a.length(), m = b.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= m; j++) {

				if (i == 0 || j == 0) dp[i][j] = (i == 0 ? j : i);
				else if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
				else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
			}
		}

		return dp[n][m];
	}



	// Time: O(n*m), Space: O(m) - TopDown DP

	static int getMinDistance3(String a, String b) {

		int n = a.length(), m = b.length();

		int[][] dp = new int[2][m + 1];
		int row = 0;


		for (int i = 0; i <= n; i++) {

			row = 1 - row;

			for (int j = 0; j <= m; j++) {

				if (i == 0 || j == 0) dp[row][j] = (i == 0 ? j : i);
				else if (a.charAt(i - 1) == b.charAt(j - 1)) dp[row][j] = dp[1 - row][j - 1];
				else dp[row][j] = 1 + Math.min(dp[1 - row][j - 1], Math.min(dp[1 - row][j], dp[row][j - 1]));
			}
		}

		return dp[row][m];
	}
}