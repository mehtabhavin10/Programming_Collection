/*

https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3583/

You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
Note:
target will be a non-zero integer in the range [-10^9, 10^9].

*/

class Solution {
    public int reachNumber(int target) {
        if (target < 0) {
            target = -target;
        }

        int step = 0;
        int totalSum = 0;
        while (target > totalSum) {
            step++;
            totalSum += step;
        }

        if (target == totalSum) {
            return step;
        } else {
            int difference = totalSum - target;
            if (difference % 2 == 0) {
                return step;
            } else {
                // difference is odd
                if ((step + 1) % 2 == 1) {
                    return step + 1;
                } else {
                    // step +1 is even
                    // step + 2 is odd
                    return step + 2;
                }
            }
        }
    }
}