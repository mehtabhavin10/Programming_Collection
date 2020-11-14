import java.util.*;

class LIS {

	public static void main(String[] args) {

		// int[] ip = {3, 10, 2, 1, 20};
		// int[] ip = {3, 2};
		int[] ip = {50, 3, 10, 7, 40, 80};

		System.out.println(getLIS(ip));
	}

	static int getLIS(int[] a) {

		if (a.length == 0) return 0;

		int[] dp = new int[a.length];
		int op = 1;

		Arrays.fill(dp, 1);


		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++)
				if (a[i] > a[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);

			op = Math.max(op, dp[i]);
		}

		return op;
	}


	// O(NlogN) Solution: https://leetcode.com/problems/longest-increasing-subsequence/
}