import java.util.*;

/*

7 10
1 2 6
1 3 5
1 4 5
3 2 -2
4 3 -2
2 5 -1
3 5 1
4 6 -1
5 7 3
6 7 3

*/

class BellmonFord {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int v = in.nextInt();
		int e = in.nextInt();
		Edge[] edges = new Edge[e];

		for (int i = 0; i < e; i++) edges[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());

		for (int i : findShortestPath(edges, v, e, 1)) System.out.print(i + " ");
	}


	static int[] findShortestPath(Edge[] edges, int v, int e, int src) {

		int[] cost = new int[v + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = -1;
		cost[src] = 0;


		for (int i = 0; i < v - 1; i++)
			for (Edge edge : edges)
				cost[edge.dest] = Math.min(cost[edge.dest], cost[edge.src] + edge.weight);


		for (Edge edge : edges) {

			if (cost[edge.dest] > cost[edge.src] + edge.weight) {

				System.out.println("Graph contains negative weight cycle!");
				break;
			}
		}

		return cost;
	}

}