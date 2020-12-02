/*


Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false
Example 3:

Input: matrix = [], target = 0
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
0 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0) return false;

        int n = matrix[0].length;
        if (n == 0 || target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;


        int l = 0, h = m - 1;

        while (l < h) {

            int mid = (l + h + 1) >>> 1;

            if (matrix[mid][0] == target) return true;
            if (target < matrix[mid][0]) h = mid - 1;
            else l = mid;
        }

        return binSearch(matrix[l], 0, n - 1, target);
    }

    boolean binSearch(int[] a, int l, int h, int key) {

        if (l <= h) {

            int mid = (l + h) >>> 1;

            if (a[mid] == key) return true;
            if (key < a[mid]) return binSearch(a, l, mid - 1, key);
            return binSearch(a, mid + 1, h, key);
        }
        return false;
    }
}