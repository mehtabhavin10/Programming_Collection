class RotateMatrix {

	public static void main(String[] args) {

		int mat[][] = {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
		};

		// Tese Case 2
		/* int mat[][] = {
		                    {1, 2, 3},
		                    {4, 5, 6},
		                    {7, 8, 9}
		                };
		 */

		// Tese Case 3
		// int mat[][] = {
		//                 {1, 2},
		//                 {4, 5}
		//             };

		display(mat);
		rotateMat(mat);
		display(mat);
	}

	static void rotateMat(int[][] m) {

		int n = m.length;

		for (int x = 0; x < n / 2; x++) {

			for (int y = x; y < n - x - 1; y++) {

				int tmp = m[x][y];
				m[x][y] = m[y][n - 1 - x];
				m[y][n - 1 - x] = m[n - 1 - x][n - 1 - y];
				m[n - 1 - x][n - 1 - y] = m[n - 1 - y][x];
				m[n - 1 - y][x] = tmp;
			}
		}
	}

	static void display(int[][] m) {

		System.out.println();

		for (int i = 0; i < m.length; i++) {

			for (int j = 0; j < m[0].length; j++) System.out.print(m[i][j] + " ");
			System.out.println();
		}

		System.out.println();
	}
}