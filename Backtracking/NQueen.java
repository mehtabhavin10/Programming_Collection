import java.util.*;
/*

Code N Code
Aditya Verma

Site: CPAlgo
Dunzo

*/
class NQueen {

	static boolean[] col;
	static List<int[]> sol;

	public static void main(String[] args) {

		int n = 8;

		int[][] board = new int[n][n];

		col = new boolean[n];
		sol = new ArrayList<>();

		solveNQueen(board, n, 0);

		for (int[] arr : sol) {
			for (int i : arr)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	static void solveNQueen(int[][] m, int n, int row) {

		for (int i = 0; i < n; i++) {

			if (!col[i] && checkDiagonal(m, n, row, i)) {

				col[i] = true;
				m[row][i] = 1;

				if (row < n - 1) solveNQueen(m, n, row + 1);
				else {

					int[] ans = new int[n];

					for (int x = 0; x < n; x++) {

						for (int y = 0; y < n; y++) {

							if (m[x][y] == 1) {
								ans[x] = y + 1;
								break;
							}
						}
					}

					sol.add(ans);

					// return; // for only single solution;
				}

				col[i] = false;
				m[row][i] = 0;
			}
		}
	}

	static boolean checkDiagonal(int[][] m, int n, int x, int y) {

		int i = x, j = y;

		while (i >= 0 && j >= 0) if (m[i--][j--] == 1) return false;

		i = x; j = y;

		while (i < n && j < n) if (m[i++][j++] == 1) return false;

		i = x; j = y;

		while (i >= 0 && j < n) if (m[i--][j++] == 1) return false;

		i = x; j = y;

		while (i < n && j >= 0) if (m[i++][j--] == 1) return false;

		return true;
	}

}