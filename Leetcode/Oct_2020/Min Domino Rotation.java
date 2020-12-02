/*

https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3500/

In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.



Example 1:


Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation:
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation:
In this case, it is not possible to rotate the dominoes to make one row of values equal.


Constraints:

2 <= A.length == B.length <= 2 * 104
1 <= A[i], B[i] <= 6

*/
class Solution {
    public int minDominoRotations(int[] A, int[] B) {

        int op = Integer.MAX_VALUE;

        op = Math.min(op, getSwaps(A[0], A, B));
        op = Math.min(op, getSwaps(B[0], A, B));
        op = Math.min(op, getSwaps(A[0], B, A));
        op = Math.min(op, getSwaps(B[0], B, A));

        return op == Integer.MAX_VALUE ? -1 : op;
    }

    int getSwaps(int t, int[] a, int[] b) {

        int swaps = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] != t && b[i] != t) return Integer.MAX_VALUE;
            else if (a[i] != t) swaps++;
        }
        return swaps;
    }
}