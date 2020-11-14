class MaxPathSumMatrix {

	public static void main(String[] args) {

		int[][] ip = {
			{ 10, 10, 2, 0, 20, 4 },
			{ 1, 0, 0, 30, 2, 5 },
			{ 0, 10, 4, 0, 2, 0 },
			{ 1, 0, 2, 20, 0, 4 }
		};

		System.out.println(getMaxPathSum(ip));
	}


	// Max possible sum from top left to bottom right including negative values

	static int getMaxPathSum(int[][] m) {

		for (int i = 1; i < m.length; i++) m[i][0] = Math.max(m[i][0], m[i][0] + m[i - 1][0]);
		for (int j = 1; j < m[0].length; j++) m[0][j] = Math.max(m[0][j], m[0][j] + m[0][j - 1]);

		for (int i = 1; i < m.length; i++)
			for (int j = 1; j < m[0].length; j++)
				m[i][j] = Math.max(m[i][j], Math.max(m[i][j] + m[i - 1][j], m[i][j] + m[i][j - 1]));

		return m[m.length - 1][m[0].length - 1];
	}
}