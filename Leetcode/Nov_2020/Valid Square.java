/*

// https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3527/

Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True


Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.

*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        double centerX = (p1[0] + p2[0] + p3[0] + p4[0]) / 4d;
        double centerY = (p1[1] + p2[1] + p3[1] + p4[1]) / 4d;

        double[] d1 = new double[] {p1[0] - centerX, p1[1] - centerY};
        double[] d2 = new double[] {p2[0] - centerX, p2[1] - centerY};
        double[] d3 = new double[] {p3[0] - centerX, p3[1] - centerY};
        double[] d4 = new double[] {p4[0] - centerX, p4[1] - centerY};

        double r1 = Math.abs(d1[0]) + Math.abs(d1[1]);
        if (r1 == 0) {
            return false;
        }

        double r2 = Math.abs(d2[0]) + Math.abs(d2[1]);
        if (r1 != r2) {
            return false;
        }

        double r3 = Math.abs(d3[0]) + Math.abs(d3[1]);
        if (r1 != r3) {
            return false;
        }

        double r4 = Math.abs(d4[0]) + Math.abs(d4[1]);
        if (r1 != r4) {
            return false;
        }

        return Math.abs(d1[0]) + Math.abs(d2[0]) + Math.abs(d3[0]) + Math.abs(d4[0])
               == Math.abs(d1[1]) + Math.abs(d2[1]) + Math.abs(d3[1]) + Math.abs(d4[1]);
    }
}