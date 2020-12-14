/*


https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3564/

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

*/

class Solution {
    public int maxCoins(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[][] dp = new int[nums.length][nums.length];


        for (int i = 0; i < nums.length; i++) {
            int l = i == 0 ? 1 : nums[i - 1];
            int r = i == nums.length - 1 ? 1 : nums[i + 1];
            dp[i][i] = nums[i] * l * r;
        }

        for (int ctr = 1; ctr < nums.length; ctr++) {
            int i = 0;
            for (int j = ctr; j < nums.length; j++) {
                int l = i == 0 ? 1 : nums[i - 1];
                int r = j == nums.length - 1 ? 1 : nums[j + 1];
                dp[i][j] = Math.max( dp[i + 1][j] + (nums[i] * l * r),
                                     dp[i][j - 1] + (nums[j] * l * r));

                for (int k = i + 1; k < j; k++) {
                    int cur = dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], nums[k] * l * r + cur);
                }
                i++;
            }
        }

        return dp[0][nums.length - 1];

    }
}