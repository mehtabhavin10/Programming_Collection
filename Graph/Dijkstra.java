import java.util.*;

class Dijkstra {

	public static void main(String[] args) {

		int[][] graph = new int[][] {
			{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
			{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
			{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 }
		};

		int n = 9;

		for (int i : findShortestPath(graph, n, 0)) System.out.print(i + " ");
	}

	static int[] findShortestPath(int[][] g, int n, int src) {

		int[] cost = new int[n];
		boolean[] visited = new boolean[n];
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> cost[a] - cost[b]);

		q.add(src);
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;

		while (!q.isEmpty()) {

			int u = q.poll();
			visited[u] = true;

			for (int v = 0; v < n; v++) {

				if (!visited[v] && g[u][v] > 0 && u != v) {

					cost[v] = Math.min(cost[v], cost[u] + g[u][v]);
					q.add(v);
				}
			}
		}

		return cost;
	}
}