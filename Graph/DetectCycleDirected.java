package Graph;


import DS.GraphDS.GraphNode;
import java.util.*;


class DetectCycleDirected {

	static boolean hasCycle(GraphNode g, Set<GraphNode> visited, Set<GraphNode> recStk) {

		if (recStk.contains(g)) return true;
		if (visited.contains(g)) return false;

		visited.add(g);
		recStk.add(g);

		Map<GraphNode, Integer> neighbors = g.adj;

		for (GraphNode v : neighbors.keySet())
			if (hasCycle(v, visited, recStk))
				return true;

		recStk.remove(g);

		return false;
	}
}