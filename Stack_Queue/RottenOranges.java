import java.util.*;

class RottenOranges {

	public static void main(String[] args) {

		int[][] ip = {
			{2, 1, 0, 2, 1},
			{1, 0, 1, 2, 1},
			{1, 0, 0, 2, 1}
		};


		System.out.println(getMinTime(ip));
	}

	static int getMinTime(int[][] ip) {

		int n = ip.length, m = ip[0].length;

		Queue<int[]> q = new LinkedList<>();
		int fresh = 0, op = 0;

		int[][] dir = {
			{1, 0},
			{0, 1},
			{ -1, 0},
			{0, -1}
		};

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				if (ip[i][j] == 2) q.add(new int[] {i, j});
				else if (ip[i][j] == 1) fresh++;
			}
		}


		while (!q.isEmpty() && fresh > 0) {

			op++;

			int size = q.size();

			while (size-- > 0) {

				int[] curr = q.remove();

				for (int[] d : dir) {

					int x = curr[0] + d[0];
					int y = curr[1] + d[1];

					if (x >= 0 && x < n && y >= 0 && y < m && ip[x][y] == 1) {

						q.add(new int[] {x, y});
						fresh--;
						ip[x][y] = 2;
					}
				}
			}
		}

		return fresh == 0 ? op : -1;
	}
}