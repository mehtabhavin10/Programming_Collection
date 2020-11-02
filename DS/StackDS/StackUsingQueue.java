package DS.StackDS;

import DS.QueueDS.Queue;

public class StackUsingQueue<T> {

	private Queue<T> q1, q2, tmp;


	public StackUsingQueue() {

		q1 = new Queue<>();
		q2 = new Queue<>();
	}


	public StackUsingQueue(int max) {

		q1 = new Queue<>(max);
		q2 = new Queue<>(max);
	}


	public void push(T val) {

		q1.add(val);
	}


	public T pop() {

		transfer();
		T val = q1.remove();
		flipQueues();

		return val;
	}


	public T peek() {

		transfer();
		T val = q1.peek();
		q2.add(q1.remove());
		flipQueues();
		return val;
	}


	public boolean isEmpty() {
		return q1.isEmpty();
	}


	public int getSize() {
		return q1.getSize();
	}


	public void transfer() {

		while (q1.getSize() > 1) q2.add(q1.remove());
	}


	public void flipQueues() {

		tmp = q1;
		q1 = q2;
		q2 = tmp;
	}
}