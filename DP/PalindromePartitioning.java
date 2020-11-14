class PalindromePartitioning {

	public static void main(String[] args) {

		String s = "aabc";
		System.out.println(getMinCuts(s));
	}


	static int getMinCuts(String str) {

		if (str.length() == 0 || str.length() == 1) return 0;

		char[] s = str.toCharArray();
		int n = s.length;

		boolean[][] pal = new boolean[n][n];
		int[] cuts = new int[n];

		for (int i = 0; i < n; i++) pal[i][i] = true;

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {

				int j = i + l - 1;

				if (l == 2) pal[i][j] = (s[i] == s[j]);
				else pal[i][j] = ((s[i] == s[j]) && (pal[i + 1][j - 1]));
			}
		}


		for (int i = 0; i < n; i++) {

			if (!pal[0][i]) {

				cuts[i] = Integer.MAX_VALUE;

				for (int j = 0; j < i; j++)
					if (pal[j + 1][i]) cuts[i] = Math.min(cuts[i], 1 + cuts[j]);
			}
		}

		return cuts[n - 1];
	}
}