import java.util.*;

class Heap<T extends Comparable<T>> {

	List<T> heap;
	int index;
	boolean minHeap;


	Heap() {

		heap =  new ArrayList<>();
		heap.add(null);
		index = 1;
		minHeap = true;
	}


	Heap(boolean forMaxHeap) {

		heap = new ArrayList<>();
		heap.add(null);
		index = 1;
		minHeap = false;
	}




	void add(T val) {

		// if (index == size) {

		// 	if (resizable) resize();
		// 	else return;
		// }

		int pos = index++;
		heap.add(val);

		while (pos > 1 && ((minHeap && lessThan(heap.get(pos), heap.get(pos / 2)))
		                   || (!minHeap && greaterThan(heap.get(pos), heap.get(pos / 2))))) {

			swap(pos, pos / 2);
			pos /= 2;
		}
	}


	T remove() {

		if (index == 1) return null;

		T removedItem = heap.get(1);
		heap.set(1, heap.get(--index));


		int pos = 1, left = 2, right = 3, curr;

		while (left < index && ((minHeap && (greaterThan(heap.get(pos), heap.get(left)) || greaterThan(heap.get(pos), heap.get(right))))
		                        || (!minHeap && (lessThan(heap.get(pos), heap.get(left)) || lessThan(heap.get(pos), heap.get(right)))))) {

			if (minHeap) {

				if (lessThan(heap.get(left), heap.get(right))) curr = left;
				else curr = right;

			} else {

				if (greaterThan(heap.get(left), heap.get(right))) curr = left;
				else curr = right;
			}


			swap(pos, curr);
			pos = curr;

			left = 2 * pos;
			right = 2 * pos + 1;
		}

		return removedItem;
	}



	T peek() {
		return heap.get(1);
	}


	boolean isEmpty() {
		return index == 1;
	}


	// void resize() {

	// 	int newSize = (int) (size * 3 / 2 + 1);
	// 	T[] newHeap = (T[]) new Object[newSize];

	// 	for (int i = 1; i < size; i++) newHeap[i] = heap[i];

	// 	heap = newHeap;
	// }


	void swap(int i, int j) {

		T tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);
	}


	boolean lessThan(T a, T b) {
		return a.compareTo(b) == -1;
	}

	boolean greaterThan(T a, T b) {
		return a.compareTo(b) == 1;
	}
}