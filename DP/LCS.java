class LCS {

	public static void main(String[] args) {

		// String a = "AGGTAB";
		// String b = "GXTXAYB";

		String a = "ABCDGH";
		String b = "AEDFHR";

		System.out.println(getLCS(a, b));
	}


	// Time: O(n*m), Optimized Space: O(m)

	static int getLCS(String s1, String s2) {

		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();

		int[][] dp = new int[2][b.length + 1];
		int row = 0;

		for (int i = 1; i <= a.length; i++) {

			row = 1 - row;

			for (int col = 1; col <= b.length; col++) {

				if (a[i - 1] == b[col - 1]) dp[row][col] = 1 + dp[1 - row][col - 1];
				else dp[row][col] = Math.max(dp[1 - row][col], dp[row][col - 1]);
			}
		}

		return dp[row][b.length];
	}
}