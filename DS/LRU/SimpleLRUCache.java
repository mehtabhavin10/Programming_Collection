package DS.LRU;

import java.util.*;

public class SimpleLRUCache<T> {


	private Set<T> lru;
	private int capacity;


	public LRUCache(int size) {

		lru = new LinkedHashSet<>();
		capacity = size;
	}



	public void refer(T val) {

		if (!lru.contains(val)) return;

		lru.remove(val);
		lru.add(val);
	}



	public void add(T val) {

		if (lru.contains(val)) lru.remove(val);
		else if (lru.size() >= capacity) lru.remove(lru.iterator().next());
		lru.add(val);
	}


	public void display() {

		System.out.println();
		for (T i : lru) System.out.print(i + " ");
		System.out.println();
	}
}


// size: 3

// 2 3 4 3 2 4 1 5 1 4 6

// 2 2 2 2 4 3 2 4 4 5 1
//   3 3 4 3 2 4 1 5 1 4
//     4 3 2 4 1 5 1 4 6