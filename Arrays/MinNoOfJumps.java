/*

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105

*/


// O(N^2)

class Solution {
	public int jump(int[] nums) {

		int n = nums.length;
		if (n <= 1) return 0;

		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);

		for (int i = n - 1; i >= 0; i--) {

			if (i + nums[i] >= n - 1) dp[i] = 1;
			else if (nums[i] != 0)
				for (int j = Math.min(n - 1, i + nums[i]); j > i; j--)
					dp[i] = Math.min(dp[i], dp[j] + 1);

		}

		return dp[0];
	}
}


// O(N)

class Solution {
	public int jump(int[] nums) {

		int n = nums.length;
		if (n <= 1) return 0;

		int jump = 1, maxReach = nums[0], steps = nums[0];

		for (int i = 1; i < n; i++) {

			if (i == n - 1) return jump;
			maxReach = Math.max(maxReach, i + nums[i]);
			steps--;

			if (steps == 0) {

				jump++;
				steps = maxReach - i;
			}

		}

		return 0;
	}
}