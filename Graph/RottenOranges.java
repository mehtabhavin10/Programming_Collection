/*

https://leetcode.com/problems/rotting-oranges/

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.


Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

*/

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) freshCount++;
                else if (grid[i][j] == 2) q.add(new int[] {i, j});
            }
        }

        if (freshCount == 0) return 0;

        int[][] dir = {
            {0, -1},
            {0, 1},
            { -1, 0},
            {1, 0}
        };

        int time = 0;

        while (freshCount > 0 && !q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] orange = q.remove();

                for (int[] d : dir) {

                    int x = orange[0] + d[0];
                    int y = orange[1] + d[1];

                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {

                        freshCount--;
                        grid[x][y] = 2;
                        q.add(new int[] {x, y});
                    }
                }
            }

            time++;
        }

        return (freshCount == 0) ? time : -1;
    }
}