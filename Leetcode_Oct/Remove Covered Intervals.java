/*

https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/



Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.



Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1
Example 3:

Input: intervals = [[0,10],[5,12]]
Output: 2
Example 4:

Input: intervals = [[3,10],[4,10],[5,11]]
Output: 2
Example 5:

Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1


Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= intervals[i][0] < intervals[i][1] <= 10^5
All the intervals are unique.

*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int op;
        if ((op = intervals.length) == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> merged = new LinkedList<>();

        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] tmp = merged.getLast();

            if ((tmp[0] >= intervals[i][0] && intervals[i][1] >= tmp[1]) || (tmp[0] <= intervals[i][0] && intervals[i][1] <= tmp[1])) op--;

            if (intervals[i][0] <= tmp[1]) {

                merged.removeLast();
                merged.add(new int[] {tmp[0], Math.max(intervals[i][1], tmp[1])});

            } else merged.add(intervals[i]);
        }

        return op;
    }
}