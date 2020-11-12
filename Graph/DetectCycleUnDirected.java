package Graph;


import DS.GraphDS.GraphNode;
import java.util.*;


class DetectCycleUnDirected {

	public static boolean hasCycle(Map<Character, GraphNode<Character>> graph) {

		Set<GraphNode> visited = new HashSet<>();

		for (GraphNode u : graph.values()) {

			if (!visited.contains(u) && formsCycle(u, visited, null)) return true;
		}

		return false;
	}

	public static boolean formsCycle(GraphNode g, Set<GraphNode> visited, GraphNode par) {

		visited.add(g);
		Map<GraphNode, Integer> neighbors = g.adj;

		for (GraphNode v : neighbors.keySet()) {

			if (!visited.contains(v)) {

				if (formsCycle(v, visited, g)) return true;

			} else if (v != par) return true;
		}

		return false;
	}
}