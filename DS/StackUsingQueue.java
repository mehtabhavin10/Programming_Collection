class StackUsingQueue<T> {

	Queue<T> q1, q2, tmp;


	StackUsingQueue() {

		q1 = new Queue<>();
		q2 = new Queue<>();
	}


	StackUsingQueue(int max) {

		q1 = new Queue<>(max);
		q2 = new Queue<>(max);
	}


	void push(T val) {

		q1.add(val);
	}


	T pop() {

		transfer();
		T val = q1.remove();
		flipQueues();

		return val;
	}


	T peek() {

		transfer();
		T val = q1.peek();
		q2.add(q1.remove());
		flipQueues();
		return val;
	}


	boolean isEmpty() {
		return q1.isEmpty();
	}


	int getSize() {
		return q1.getSize();
	}


	void transfer() {

		while (q1.getSize() > 1) q2.add(q1.remove());
	}


	void flipQueues() {

		tmp = q1;
		q1 = q2;
		q2 = tmp;
	}
}