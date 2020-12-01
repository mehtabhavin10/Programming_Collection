class WildcardPatternMatching {

	public static void main(String[] args) {

		String[][] ip = {
			{ "aa", "a"},
			{ "aa", "*"},
			{ "cb", "?a"},
			{ "adceb", "*a*b"},
			{ "acdcb", "a*c?b"}
		};

		for (String[] i : ip) System.out.println(isMatch(i[0], i[1]));
		System.out.println();
		for (String[] i : ip) System.out.println(isMatch2(i[0], i[1]));
	}


	// DP Approach, Time: O(n.m) Space: O(n.m)

	static boolean isMatch(String a, String b) {

		char[] s = a.toCharArray();
		char[] p = b.toCharArray();

		int n = s.length, m = p.length;

		if (m == 0) return (n == 0);

		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int i = 1; i <= m; i++) if (p[i - 1] == '*') dp[0][i] = dp[0][i - 1];

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= m; j++) {

				if (p[j - 1] == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				else if (s[i - 1] == p[j - 1] || p[j - 1] == '?') dp[i][j] = dp[i - 1][j - 1];
				else dp[i][j] = false;
			}
		}

		return dp[n][m];
	}



	// Time: O(n+m) Space: O(1)

	static boolean isMatch2(String a, String b) {

		char[] s = a.toCharArray();
		char[] p = b.toCharArray();

		int n = s.length, m = p.length;

		if (m == 0) return n == 0;

		int i = 0, j = 0, starI = -1, starJ = -1;

		while (i < n) {

			if (j < m && (s[i] == p[j] || p[j] == '?')) {

				i++;
				j++;

			} else if (j < m && p[j] == '*') {

				starJ = j++;
				starI = i;

			} else if (starI != -1) {

				i = ++starI;
				j = starJ + 1;

			} else return false;
		}

		while (j < m && p[j] == '*') j++;

		return j == m;
	}
}