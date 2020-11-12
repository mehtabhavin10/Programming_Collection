package Graph;

import DS.GraphDS.GraphNode;
import DS.StackDS.Stack;
import java.util.*;


class TarjanSCC {

	static Stack<GraphNode> stk = new Stack<>();
	static Map<GraphNode, Integer> dfsNum = new HashMap<>();
	static Map<GraphNode, Integer> low = new HashMap<>();
	static Set<GraphNode> visited = new HashSet<>();
	static Map<Integer, GraphNode<Integer>> graph;
	static int num = 0;

	public static void main(String[] args) {


		graph = new HashMap<>();


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

		stk = new Stack<>();
		dfsNum = new HashMap<>();
		low = new HashMap<>();
		visited = new HashSet<>();

		findSCC(graph.get(src));
	}

	static void findSCC(GraphNode g) {

		dfsNum.put(g, num);
		low.put(g, num++);
		visited.add(g);
		stk.push(g);


		Map<GraphNode, Integer> neighbors = g.adj;

		for (GraphNode v : neighbors.keySet()) {

			if (!dfsNum.containsKey(v)) {

				findSCC(v);
				low.put(g, Math.min(low.get(g), low.get(v)));

			} else if (visited.contains(v)) low.put(g, Math.min(low.get(g), dfsNum.get(v)));
		}


		if (low.get(g) == dfsNum.get(g)) {

			GraphNode tmp;

			do {

				tmp = stk.pop();
				System.out.print(tmp.data + " ");
				visited.remove(tmp);

			} while (tmp != g);

			System.out.println();
		}

	}
}