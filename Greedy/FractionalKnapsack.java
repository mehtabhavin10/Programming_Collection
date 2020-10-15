import java.util.*;

class FractionalKnapsack {

	public static void main(String[] args) {

		int[] w = {10, 40, 20, 30};
		int[] v = {60, 40, 100, 120};
		int capacity = 50;

		System.out.println(getMaxItems(w, v, capacity));
	}

	static double getMaxItems(int[] w, int[] v, int capacity) {

		int n = w.length;

		Item[] items = new Item[n];

		for (int i = 0; i < n; i++) items[i] = new Item(w[i], v[i], i + 1);

		Arrays.sort(items, (a, b)->Double.compare(b.profitPerWeight, a.profitPerWeight));

		int i = 0;
		double op = 0.0;

		for (; i < n; i++) {

			if (items[i].w > capacity) break;
			op += items[i].v;
			capacity -= items[i].w;
		}

		if (i < n) op += (double)items[i].v * (capacity / (double)items[i].w);

		return op;
	}
}

class Item {

	int w, v, sr;
	double profitPerWeight;

	Item(int wt, int val, int i) {

		w = wt;
		v = val;
		sr = i;
		profitPerWeight = (double)v / (double)w;
	}
}