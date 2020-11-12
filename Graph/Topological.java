package Graph;


import DS.GraphDS.GraphNode;
import DS.QueueDS.Queue;
import java.util.*;


class Topological {

	public static void sort(Map<Character, GraphNode<Character>> graph) {

		Map<GraphNode, Integer> inDegree = new HashMap<>();

		for (GraphNode u : graph.values()) {

			if (!inDegree.containsKey(u)) inDegree.put(u, 0);
			Map<GraphNode, Integer> neighbors = u.adj;

			for (GraphNode v : neighbors.keySet())
				inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
		}


		Queue<GraphNode> q = new Queue<>();


		for (GraphNode g : inDegree.keySet())
			if (inDegree.get(g) == 0)
				q.add(g);


		while (!q.isEmpty()) {

			GraphNode curr = q.remove();

			System.out.print(curr.data + " ");

			Map<GraphNode, Integer> neighbors = curr.adj;

			for (GraphNode v : neighbors.keySet()) {

				int degree = inDegree.get(v) - 1;

				if (degree == 0) q.add(v);
				inDegree.put(v, degree);
			}
		}
	}
}