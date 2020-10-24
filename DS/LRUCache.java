import java.util.*;

class LRUCache<E, T> {


	Set<E> lru;
	int capacity;
	Map<E, T> map;


	LRUCache(int size) {

		lru = new LinkedHashSet<>();
		capacity = size;
		map = new HashMap<>();
	}



	T refer(E key) {

		if (!lru.contains(key)) return null;

		lru.remove(key);
		lru.add(key);

		return map.get(key);
	}



	void add(E key, T val) {

		if (lru.contains(key)) lru.remove(key);
		else if (lru.size() >= capacity) {

			E firstEntry = lru.iterator().next();
			lru.remove(firstEntry);
			map.remove(firstEntry);
		}

		lru.add(key);
		map.put(key, val);
	}


	void display() {

		System.out.println();
		for (E i : lru) System.out.println(i + " -> " + map.get(i));
		System.out.println();
	}
}


// size: 3

// 2 3 4 3 2 4 1 5 1 4 6

// 2 2 2 2 4 3 2 4 4 5 1
//   3 3 4 3 2 4 1 5 1 4
//     4 3 2 4 1 5 1 4 6