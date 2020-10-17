class MColoringGraph {

	public static void main(String[] args) {

		int graph[][] = {
			{ 0, 1, 1, 1 },
			{ 1, 0, 1, 0 },
			{ 1, 1, 0, 1 },
			{ 1, 0, 1, 0 },
		};

		int m = 3, n = 4;

		int[] color = new int[n];

		if (solve(graph, n, m, color, 0)) for (int i : color) System.out.print(i + " ");
		else System.out.println("Not Found!");
	}

	static boolean solve(int[][] g, int n, int m, int[] color, int index) {

		if (index == n) return true;

		for (int i = 1; i <= m; i++) {

			if (isSafe(g[index], n, i, color)) {

				color[index] = i;

				if (solve(g, n, m, color, index + 1)) return true;
			}
		}

		return false;
	}

	static boolean isSafe(int[] adj, int n, int c, int[] color) {

		for (int i = 0; i < n; i++)
			if (adj[i] == 1 && color[i] == c) return false;
		return true;
	}
}