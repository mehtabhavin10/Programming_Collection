import java.util.*;

class EggDroping {

	public static void main(String[] args) {

		// System.out.println(getMinAttemptsRec(3, 14));	// 4
		// System.out.println(getMinAttemptsRec(4, 8));	// 4

		// System.out.println(getMinAttempts(3, 14));	// 4
		// System.out.println(getMinAttempts(5, 5));	// 3

		System.out.println(getMinAttemptsBin(3, 14));	// 4
		System.out.println(getMinAttemptsBin(5, 5));	// 3

		// System.out.println(getMinAttemptsMath(3, 14));	// 4
		// System.out.println(getMinAttemptsMath(5, 5));	// 3
	}



	//	Recursive Solution - Time Complexity: Exponential

	static int getMinAttemptsRec(int eggs, int floors) {

		if (floors == 0 || floors == 1 || eggs == 1) return floors;

		int min = Integer.MAX_VALUE;

		for (int x = 1; x <= floors; x++)
			min = Math.min(min, Math.max(getMinAttemptsRec(eggs - 1, x - 1), getMinAttemptsRec(eggs, floors - x)));

		return min + 1;
	}



	// DP Solution - Time Complexity: O(n^2 * k)  ;  n-floors, k-eggs  i.e.O(floors^2 * eggs)

	static int getMinAttempts(int eggs, int floors) {

		if (floors == 0 || floors == 1 || eggs == 1) return floors;


		int[][] dp = new int[floors + 1][eggs + 1];

		for (int i = 0; i <= floors; i++) dp[i][1] = i;
		for (int i = 0; i <= eggs; i++) dp[1][i] = 1;


		for (int i = 2; i <= floors; i++) {

			for (int j = 2; j <= eggs; j++) {

				dp[i][j] = Integer.MAX_VALUE;

				for (int x = 1; x < i; x++)
					dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
			}
		}

		// for (int i = 0; i <= floors; i++) {

		// 	for (int j = 0; j <= eggs; j++) System.out.print(dp[i][j] + " ");
		// 	System.out.println();
		// }

		return dp[floors][eggs];
	}




	// DP + Bin Search Solution: Complexity: O(N*K*LogN)

	static int getMinAttemptsBin(int eggs, int floors) {

		int[][] dp = new int[floors + 1][eggs + 1];

		for (int i = 1; i <= floors; i++) Arrays.fill(dp[i], Integer.MAX_VALUE - 1);


		for (int i = 1; i <= floors; i++) {

			for (int j = 1; j <= eggs; j++) {

				int low = 1, high = i - 1;

				while (low < high) {

					int mid = (low + high) >>> 1;

					if (dp[mid - 1][j - 1] >= dp[i - mid][j]) high = mid;
					else low = mid + 1;
				}

				int x = low;
				dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));

				x--;
				if (x > 0) dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
			}
		}

		return dp[floors][eggs];
	}




	// Maths Solution - Complexity: O(k*max(t)) ; k - no of eggs, t - attempts

	static int getMinAttemptsMath(int eggs, int floors) {

		int[] dp = new int[eggs + 1];
		int op = 0;

		while (dp[eggs] < floors) {

			for (int i = eggs; i >= 1; i--) dp[i] += 1 + dp[i - 1];
			op++;
		}

		return op;
	}
}