/*


https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/


Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

1 <= n <= 20

*/

class Solution {
    public int[][] generateMatrix(int n) {

        int[][] op = new int[n][n];
        int v = 1, end = (int)Math.pow(n, 2);
        int rS = 0, rE = n - 1, cS = 0, cE = n - 1;

        while (v <= end) {

            for (int i = cS; i <= cE; i++) op[rS][i] = v++;

            if (v > end) break;
            rS++;

            for (int i = rS; i <= rE; i++) op[i][cE] = v++;

            if (v > end) break;
            cE--;

            for (int i = cE; i >= cS; i--) op[rE][i] = v++;

            if (v > end) break;
            rE--;

            for (int i = rE; i >= rS; i--) op[i][cS] = v++;

            cS++;
        }

        return op;
    }
}