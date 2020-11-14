import java.util.*;

/*

4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4

*/

class KruskalsMST {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int v = in.nextInt();
		int e = in.nextInt();
		Edge[] edges = new Edge[e];

		for (int i = 0; i < e; i++) edges[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());

		for (Edge i : findMST(edges, v, e)) System.out.println(i.src + " " + i.dest + " " + i.weight);
	}


	static Edge[] findMST(Edge[] edge, int v, int e) {

		Edge[] mst = new Edge[v - 1];
		int index = 0;

		Arrays.sort(edge, (a, b) -> a.weight - b.weight);
		int min = 0;

		Subset[] subset = new Subset[v];
		for (int i = 0; i < v; i++) subset[i] = new Subset(i);



		while (min < e && index < v - 1) {

			Edge curr = edge[min];

			if (find(subset, curr.src) != find(subset, curr.dest)) {

				mst[index++] = curr;
				union(subset, curr.src, curr.dest);
			}

			min++;
		}

		return mst;
	}


	static int find(Subset[] subset, int i) {
		if (i != subset[i].par) return find(subset, subset[i].par);
		return i;
	}


	static void union(Subset[] subset, int u, int v) {

		int parX = find(subset, u);
		int parY = find(subset, v);

		if (subset[parX].rank > subset[parY].rank) {

			subset[parY].par = parX;
			subset[parX].rank++;

		} else {

			subset[parX].par = parY;
			subset[parY].rank++;
		}
	}
}
