class DriverCode {

	public static void main(String[] args) {

		MinStackInteger stk = new MinStackInteger();

		stk.push(89);
		stk.push(24);
		stk.push(12);
		stk.push(38);

		System.out.println(stk.peek());
		System.out.println(stk.getMin());

		stk.pop();
		stk.pop();

		System.out.println(stk.peek());
		System.out.println(stk.getMin());

		stk.push(3);

		System.out.println(stk.peek());
		System.out.println(stk.getMin());

		System.out.println(stk.isEmpty());

		stk.pop();
		stk.pop();

		System.out.println(stk.isEmpty());

		stk.pop();
		System.out.println(stk.isEmpty());
	}
}