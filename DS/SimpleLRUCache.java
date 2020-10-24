import java.util.*;

class SimpleLRUCache<T> {


	Set<T> lru;
	int capacity;


	LRUCache(int size) {

		lru = new LinkedHashSet<>();
		capacity = size;
	}



	void refer(T val) {

		if (!lru.contains(val)) return;

		lru.remove(val);
		lru.add(val);
	}



	void add(T val) {

		if (lru.contains(val)) lru.remove(val);
		else if (lru.size() >= capacity) lru.remove(lru.iterator().next());
		lru.add(val);
	}


	void display() {

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