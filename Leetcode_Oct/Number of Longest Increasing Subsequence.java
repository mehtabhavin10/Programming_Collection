/*


Given an integer array nums, return the number of longest increasing subsequences.



Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.



Constraints:

0 <= nums.length <= 2000
-106 <= nums[i] <= 106

*/
class Solution {
    public int findNumberOfLIS(int[] nums) {

        if (nums.length == 0) return 0;

        int[] dpLen = new int[nums.length];
        int[] dpCnt = new int[nums.length];

        Arrays.fill(dpLen, 1);
        Arrays.fill(dpCnt, 1);

        int max = 1, op = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    if (dpLen[i] == dpLen[j] + 1) dpCnt[i] += dpCnt[j];
                    else if (dpLen[i] < dpLen[j] + 1) {

                        dpLen[i] = dpLen[j] + 1;
                        dpCnt[i] = dpCnt[j];
                    }
                }
            }

            if (dpLen[i] > max) {

                max = dpLen[i];
                op = dpCnt[i];

            } else if (max == dpLen[i]) op += dpCnt[i];
        }


        // for(int i=0;i<nums.length;i++) if(dpLen[i] == max) op += dpCnt[i];

        return op;
    }
}