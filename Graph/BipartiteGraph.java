class BipartiteGraph {

	public static void main(String[] args) {

		int[][] graph = {
			{ 0, 1, 0, 1 },
			{ 1, 0, 1, 0 },
			{ 0, 1, 0, 1 },
			{ 1, 0, 1, 0 }
		};

		System.out.println(isBipartite(graph));
	}

	static boolean isBipartite(int[][] g) {

		int[] color = new int[g.length];
		for (int i = 0; i < g.length; i++) if (color[i] == 0 && !isValid(g, color, i, 1)) return false;
		return true;
	}

	static boolean isValid(int[][] g, int[] color, int i, int c) {

		if (color[i] != 0) return color[i] == c;
		color[i] = c;
		for (int j = 0; j < g[i].length; j++) if (g[i][j] == 1 && !isValid(g, color, j, -c)) return false;
		return true;
	}
}