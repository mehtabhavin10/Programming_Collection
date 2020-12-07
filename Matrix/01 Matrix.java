/*

https://leetcode.com/problems/01-matrix/

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]


Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.

*/


class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;

        int[][] dir = {{1, 0}, {0, 1}, { -1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {

                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }


        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.remove();

                for (int[] d : dir) {

                    int x = curr[0] + d[0], y = curr[1] + d[1];

                    if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y]) {

                        q.add(new int[] {x, y});
                        visited[x][y] = true;
                        matrix[x][y] = matrix[curr[0]][curr[1]] + 1;
                    }
                }
            }
        }


        return matrix;
    }
}