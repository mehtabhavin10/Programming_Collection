/*


https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3591/


Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by these n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Given an integer n, return the number of the beautiful arrangements that you can construct.



Example 1:

Input: n = 2
Output: 2
Explanation:
The first beautiful arrangement is [1, 2]:
Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
The second beautiful arrangement is [2, 1]:
Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Example 2:

Input: n = 1
Output: 1


Constraints:

1 <= n <= 15

*/

class Solution {
    public int countArrangement(int n) {

        return backtrack(n, new boolean[n + 1], 1);
    }

    private int backtrack(int n, boolean[] used, int pos) {
        if (pos - 1 == n) return 1;

        int ans = 0;

        for (int num = 1; num <= n; num++) {
            if (used[num]) continue;

            if (num % pos == 0 || pos % num == 0) {
                used[num] = true;

                ans += backtrack(n, used, pos + 1);

                used[num] = false;
            }
        }

        return ans;
    }
}