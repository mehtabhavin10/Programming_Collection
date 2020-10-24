class Stack<T> {

	LinkedList<T> linkedList;

	Stack() {

		linkedList = new LinkedList<>();
	}

	Stack(int max) {

		linkedList = new LinkedList<>(max);
	}

	void push(T data) {

		linkedList.insertBegin(data);
	}


	T pop() {

		T op = linkedList.get(0);
		linkedList.deleteBegin();
		return op;
	}


	T peek() {

		if (isEmpty()) return null;
		return linkedList.get(0);
	}


	boolean isEmpty() {

		return linkedList.isEmpty();
	}

	int getSize() {
		return linkedList.getSize();
	}
}