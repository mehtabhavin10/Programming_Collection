class RatInMaze {

	public static void main(String[] args) {

		int maze[][] = {
			{ 1, 0, 0, 0 },
			{ 1, 1, 0, 1 },
			{ 0, 1, 0, 0 },
			{ 1, 1, 1, 1 }
		};

		int m = 4, n = 4;

		int[][] ans = new int[m][n];

		if (solve(maze, m, n, 0, 0, ans)) {

			ans[0][0] = 1;

			for (int[] arr : ans) {
				for (int i : arr)
					System.out.print(i + " ");
				System.out.println();
			}

		} else System.out.println("No Path Found!");
	}



	static boolean solve(int[][] maze, int m, int n, int x, int y, int[][] ans) {


		if (x == m - 1 && y == n - 1) return true;

		if (isSafe(maze, m, n, x + 1, y) && solve(maze, m, n, x + 1, y, ans)) {

			ans[x + 1][y] = 1;
			return true;
		}

		if (isSafe(maze, m, n, x, y + 1) && solve(maze, m, n, x, y + 1, ans)) {

			ans[x][y + 1] = 1;
			return true;
		}

		if (isSafe(maze, m, n, x - 1, y) && solve(maze, m, n, x - 1, y, ans)) {

			ans[x - 1][y] = 1;
			return true;
		}

		if (isSafe(maze, m, n, x, y - 1) && solve(maze, m, n, x, y - 1, ans)) {

			ans[x][y - 1] = 1;
			return true;
		}

		return false;
	}


	static boolean isSafe(int[][] maze, int m, int n, int x, int y) {

		return (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 1);
	}
}