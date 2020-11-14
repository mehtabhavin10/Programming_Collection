import java.util.*;

class PrimsMST {

	static int[] par, cost;

	public static void main(String[] args) {

		int[][] graph = {
			{ 0, 2, 0, 6, 0 },
			{ 2, 0, 3, 8, 5 },
			{ 0, 3, 0, 0, 7 },
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 }
		};

		int n = 5;

		findMST(graph, n, 0);

		for (int i = 0; i < n; i++) System.out.println("Src: " + par[i] + ", Dest: " + i + ", Cost: " + cost[i]);
	}


	static void findMST(int[][] g, int n, int src) {

		cost = new int[n];
		par = new int[n];

		boolean[] visited = new boolean[n];
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> cost[a] - cost[b]);

		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;
		par[src] = -1;
		q.add(src);

		while (!q.isEmpty()) {

			int u = q.poll();
			visited[u] = true;

			for (int v = 0; v < n; v++) {

				if (!visited[v] && u != v && g[u][v] > 0 && g[u][v] < cost[v]) {

					cost[v] = g[u][v];
					q.add(v);
					par[v] = u;
				}
			}
		}
	}
}