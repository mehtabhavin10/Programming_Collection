package Graph;

import DS.GraphDS.GraphNode;
import DS.QueueDS.Queue;
import java.util.*;


/*

7
a b c d e f g
7
b a
b c
b f
c d
e d
e f
f g
a

*/

class GraphTrav {

	public static void main(String[] args) {

		Map<Character, GraphNode<Character>> graph = new HashMap<>();


		// Genration of graph based on input!  ----------------------

		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());

		String[] line = in.nextLine().trim().split(" ");

		for (String s : line) graph.put(s.charAt(0), new GraphNode(s.charAt(0)));

		n = Integer.parseInt(in.nextLine());

		while (n-- > 0) {

			line = in.nextLine().trim().split(" ");

			char u = line[0].charAt(0);
			char v = line[1].charAt(0);
			// int cost = in.nextInt();

			GraphNode src = graph.get(u);
			GraphNode dest = graph.get(v);

			src.addAdj(dest);
			// dest.addAdj(src);
		}

		char src = in.nextLine().trim().split(" ")[0].charAt(0);


		// ----------------------------------------------------------

		// for (Character c : graph.keySet()) {

		// 	System.out.print(c + " -> ");

		// 	for (GraphNode v : graph.get(c).adj.keySet()) {

		// 		System.out.print(v.data + " ");
		// 	}
		// 	System.out.println();
		// }

		System.out.print("BFS: ");
		bfs(graph.get(src));

		System.out.println("\n");

		System.out.print("DFS: ");
		dfs(graph.get(src), new HashSet<>());

		System.out.println("\n");
		System.out.print("Has Cycle Directed: " + DetectCycleDirected.hasCycle(graph.get(src), new HashSet<>(), new HashSet<>()));

		System.out.println("\n");
		System.out.print("Has Cycle UnDirected: " + DetectCycleUnDirected.hasCycle(graph));

		System.out.println("\n");
		System.out.print("Topological Sort: ");
		Topological.sort(graph);

	}


	public static void bfs(GraphNode u) {

		Queue<GraphNode> q = new Queue<>();
		Set<GraphNode> visited = new HashSet<>();

		q.add(u);
		visited.add(u);

		while (!q.isEmpty()) {

			GraphNode curr = q.remove();
			System.out.print(curr.data + " ");

			Map<GraphNode, Integer> tmp = curr.adj;

			for (GraphNode v : tmp.keySet()) {

				if (!visited.contains(v)) {

					q.add(v);
					visited.add(v);
				}
			}
		}
	}



	public static void dfs(GraphNode u, Set<GraphNode> visited) {

		visited.add(u);
		System.out.print(u.data + " ");
		Map<GraphNode, Integer> tmp = u.adj;
		for (GraphNode v : tmp.keySet()) if (!visited.contains(v)) dfs(v, visited);
	}
}
