/*

https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3533/

Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?

*/
class Solution {
    public int longestMountain(int[] A) {

        int n = A.length;
        if (n < 3) return 0;

        int i = 1, l = 0, h = 0, op = 0;

        while (i < n) {

            while (i < n && A[i - 1] >= A[i]) i++;
            l = i - 1;
            while (i < n && A[i - 1] < A[i]) i++;

            if (i >= n) break;

            while (i < n && A[i - 1] > A[i]) i++;

            h = i - 1;

            if (l != h && (h - l + 1 >= 3)) op = Math.max(op, h - l + 1);
            l = i;
            h = i;
        }

        return op;
    }
}