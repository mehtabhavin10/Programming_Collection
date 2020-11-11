package DS.GraphDS;

import java.util.*;

public class GraphNode<T> {

	public T data;
	public Map<GraphNode, Integer> adj;

	public GraphNode(T data) {

		this.data = data;
		adj = new HashMap<GraphNode, Integer>();
	}


	public GraphNode(Map<GraphNode, Integer> adj) {
		this.adj = adj;
	}


	public GraphNode(T data, Map<GraphNode, Integer> adj) {

		this.data = data;
		this.adj = adj;
	}

	public void addAdj(GraphNode v) {
		adj.put(v, 0);
	}


	public void addAdj(GraphNode v, int pathCost) {
		adj.put(v, pathCost);
	}

	public Map<GraphNode, Integer> getAdj() {
		return adj;
	}
}