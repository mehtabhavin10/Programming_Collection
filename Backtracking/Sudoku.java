class Sudoku {

	public static void main(String[] args) {

		int[][] m = {
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }
		};

		solve(m, 0, 0);

		for (int arr[] : m) {

			for (int i : arr) System.out.print(i + " ");
			System.out.println();
		}
	}

	static boolean solve(int[][] board, int x, int y) {

		boolean noEmpty = true;

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				if (board[i][j] == 0) {

					noEmpty = false;
					boolean nothingSafe = true;

					for (int k = 1; k <= 9; k++) {

						if (isSafe(board, i, j, k)) {

							nothingSafe = false;
							board[i][j] = k;

							if (solve(board, i, j)) return true;
						}
					}

					if (nothingSafe) return false;
				}
			}
		}

		if (noEmpty) return true;
		return false;
	}


	static boolean isSafe(int[][] m, int x, int y, int n) {


		for (int i = 0; i < 9; i++) if (m[x][i] == n) return false;
		for (int i = 0; i < 9; i++) if (m[i][y] == n) return false;

		int rowStart = x - (x % 3), colStart = y - (y % 3);

		for (int i = rowStart; i < rowStart + 3; i++) {

			for (int j = colStart; j < colStart + 3; j++) {

				if (i == x && j == y) continue;

				if (m[i][j] == n) return false;
			}
		}


		return true;
	}
}