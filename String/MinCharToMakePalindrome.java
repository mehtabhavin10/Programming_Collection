import java.util.*;

class MinCharToMakePalindrome {

	public static void main(String[] args) {

		String[] ip = {
			"AACECAAAA",
			"zzazz",
			"mbadm",
			"leetcode",
			""
		};


		for (String s : ip) System.out.println(minCharAnywhere(s));
		System.out.println();
		for (String s : ip) System.out.println(minCharFront(s));
	}


	// Add Char anywhere : using LCS O(N^2)  - LCS of s, reverse(s)

	static int minCharAnywhere(String s) {

		int lcs = getLCS(s.toCharArray(), new StringBuilder(s).reverse().toString().toCharArray(), s.length());
		return s.length() - lcs;
	}


	static int getLCS(char[] a, char[] b, int n) {

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {

				if (a[i - 1] == b[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n][n];
	}




	// Add char only in front : using LPS of KMP O(N) - generating lps table of s$reverse(s)

	static int minCharFront(String s) {

		char[] ip = (s + "$" + new StringBuilder(s).reverse().toString()).toCharArray();
		int[] lps = getLPS(ip);

		return s.length() - lps[ip.length - 1];
	}


	static int[] getLPS(char[] pat) {

		int m = pat.length;
		int i = 1, j = 0;

		int[] lps = new int[m];

		while (i < m) {

			if (pat[i] == pat[j]) {

				lps[i] = j + 1;
				i++;
				j++;

			} else if (j > 0) j = lps[j - 1];
			else lps[i++] = 0;
		}

		return lps;
	}
}