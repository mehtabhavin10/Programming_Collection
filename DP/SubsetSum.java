import java.util.*;

class SubsetSum {

	public static void main(String[] args) {

		int[] ip = { 3, 34, 4, 12, 5, 2 };
		int k = 9;

		System.out.println(recursiveSubsetSum(ip, ip.length, k));
		System.out.println(dpSubsetSum(ip, ip.length, k));
	}


	// Exponential Complexity

	static boolean recursiveSubsetSum(int[] a, int n, int k) {

		if (k == 0) return true;
		if (n == 0) return false;

		if (a[n - 1] > k) return recursiveSubsetSum(a, n - 1, k);

		return recursiveSubsetSum(a, n - 1, k - a[n - 1]) || recursiveSubsetSum(a, n - 1, k);
	}


	// Pseudo-Polynomial Time - O(sum*n) + Space: O(sum*n)

	static boolean dpSubsetSum(int[] a, int n, int sum) {

		boolean[][] dp = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++) dp[0][i] = true;


		for (int i = 1; i <= sum; i++) {

			for (int j = 1; j <= n; j++) {

				dp[i][j] = dp[i][j - 1];

				if (i >= a[j - 1]) dp[i][j] = dp[i][j] || dp[i - a[j - 1]][j - 1];
			}
		}

		// for (int i = 0; i <= sum; i++) {

		// 	for (int j = 0; j <= n; j++) System.out.print(dp[i][j] + " ");
		// 	System.out.println();
		// }

		return dp[sum][n];
	}
}