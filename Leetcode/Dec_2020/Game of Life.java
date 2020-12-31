/*

https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3586/

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.



Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.


Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?

*/

class Solution {

    int[][] dirs = {{ -1, -1}, { -1, 0}, {0, -1}, {1, 0}, {0, 1}, {1, 1}, {1, -1}, { -1, 1}};
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0;  i < row; i++) {
            for (int j = 0; j < col; j++) {
                int nei = calNei(board, i, j, row, col);
                if (nei == 3 || (nei == 2 && ((board[i][j] & 1) == 1))) {
                    board[i][j] = (board[i][j] & 1) | (1 << 1);
                }
            }
        }
        for (int i = 0;  i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
        return;
    }

    private int calNei(int[][]board, int x, int y, int row, int col) {
        int sum = 0;
        for (int[] dir : dirs) {
            int x0 = x + dir[0];
            int y0 = y + dir[1];
            if (x0 < 0 || x0 > row - 1 || y0 < 0 || y0 > col - 1) continue;
            sum += board[x0][y0] & 1;
        }
        return sum;
    }
}