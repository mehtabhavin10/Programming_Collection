package Graph;

import DS.GraphDS.GraphNode;
import DS.StackDS.Stack;
import java.util.*;

/*

5
0 1 2 3 4
5
2 1
1 0
0 2
0 3
3 4
1

*/


class KosarajuSCC {

	public static void main(String[] args) {


		Map<Integer, GraphNode<Integer>> graph = new HashMap<>();


		// Directed Graph

		// Genration of graph based on input!  ----------------------

		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());

		String[] line = in.nextLine().trim().split(" ");

		for (String s : line) graph.put(s.charAt(0) - '0', new GraphNode(s.charAt(0) - '0'));

		n = Integer.parseInt(in.nextLine());

		while (n-- > 0) {

			line = in.nextLine().trim().split(" ");

			int u = line[0].charAt(0) - '0';
			int v = line[1].charAt(0) - '0';
			// int cost = in.nextInt();

			GraphNode src = graph.get(u);
			GraphNode dest = graph.get(v);

			src.addAdj(dest);
		}

		int src = in.nextLine().trim().split(" ")[0].charAt(0) - '0';


		// ----------------------------------------------------------


		findSCC(graph, src);
	}


	public static void findSCC(Map<Integer, GraphNode<Integer>> graph, int src) {

		Set<GraphNode> visited = new HashSet<>();
		Stack<Integer> stk = new Stack<>();

		traverseAndMark(graph.get(src), visited, stk);
		Map<Integer, GraphNode<Integer>> invGraph = invertGraph(graph);

		visited.clear();

		while (!stk.isEmpty()) {

			int curr = stk.pop();

			if (visited.contains(invGraph.get(curr))) continue;

			dfs(invGraph, invGraph.get(curr), visited);
			System.out.println();
		}
	}


	static void traverseAndMark(GraphNode g, Set<GraphNode> visited, Stack<Integer> stk) {

		visited.add(g);

		Map<GraphNode, Integer> neighbors = g.adj;

		for (GraphNode v : neighbors.keySet())
			if (!visited.contains(v))
				traverseAndMark(v, visited, stk);

		stk.push(Integer.parseInt(g.data + ""));
	}


	static Map<Integer, GraphNode<Integer>> invertGraph(Map<Integer, GraphNode<Integer>> graph) {

		Map<Integer, GraphNode<Integer>> invGraph = new HashMap<>();

		for (int g : graph.keySet()) invGraph.put(g, new GraphNode(g));

		for (int u : graph.keySet())
			for (GraphNode v : graph.get(u).adj.keySet())
				invGraph.get(v.data).addAdj(invGraph.get(u));

		return invGraph;
	}


	static void dfs(Map<Integer, GraphNode<Integer>> graph, GraphNode g, Set<GraphNode> visited) {

		visited.add(g);
		System.out.print(g.data + " ");

		Map<GraphNode, Integer> neighbors = g.adj;

		for (GraphNode v : neighbors.keySet())
			if (!visited.contains(v))
				dfs(graph, v, visited);
	}
}