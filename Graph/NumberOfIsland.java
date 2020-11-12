class NumberOfIsland {

	static int[][] dir = {
		{1, 0},
		{0, 1},
		{ -1, 0},
		{0, -1}
	};

	public static void main(String[] args) {

		int[][] ip = {
			{ 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 }
		};

		System.out.println(numOfIsland(ip));
	}

	public static int numOfIsland(int[][] mat) {

		int n, m;
		if ((n = mat.length) == 0) return 0;
		if ((m = mat[0].length) == 0) return 0;

		int op = 0;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				if (mat[i][j] == 1) {

					op++;
					removeIsland(mat, i, j, n, m);
				}
			}
		}

		return op;
	}


	public static void removeIsland(int[][] mat, int x, int y, int n, int m) {

		mat[x][y] = 0;

		for (int[] d : dir) {

			int x2 = x + d[0];
			int y2 = y + d[1];

			if (x2 < 0 || y2 < 0 || x2 >= n || y2 >= m || mat[x2][y2] != 1) continue;

			removeIsland(mat, x2, y2, n, m);
		}
	}
}