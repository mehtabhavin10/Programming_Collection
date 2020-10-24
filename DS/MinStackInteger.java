/*

Advantages:
	- Constant extra space O(1)
	- Constant Time for getMin() & other operations


Disadvantages:
	- Doesn't store actual values in stack

*/

class MinStackInteger {

	Stack<Integer> stk;
	int min;

	MinStackInteger() {

		stk = new Stack<>();
		min = Integer.MAX_VALUE;
	}


	MinStackInteger(int max) {

		stk = new Stack<>(max);
		min = Integer.MAX_VALUE;
	}


	int getMin() {
		return min;
	}


	void push(int val) {

		if (stk.isEmpty()) {

			min = val;
			stk.push(val);
			return;
		}

		if (val > min) stk.push(val);
		else {

			stk.push((2 * val) - min);
			min = val;
		}
	}


	int pop() {

		int val = stk.pop();

		if (val >= min) return val;

		int tmp = min;
		min = (2 * min) - val;
		return min;
	}


	int peek() {
		return Math.max(min, stk.peek());
	}


	boolean isEmpty() {
		return stk.isEmpty();
	}
}