/*


https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3535/



Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

*/
class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        if (n == 0) return intervals;

        Arrays.sort(intervals, (a, b)->a[0] - b[0]);
        List<int[]> op = new ArrayList<>();

        int[] prev = intervals[0];
        int i = 1;

        while (i < n) {

            if (prev[1] >= intervals[i][0]) prev[1] = Math.max(intervals[i][1], prev[1]);
            else {

                op.add(prev);
                prev = intervals[i];
            }

            i++;
        }

        op.add(prev);

        int[][] res = new int[op.size()][2];
        i = 0;
        for (int[] a : op) res[i++] = a;

        return res;
    }
}