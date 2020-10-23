class DriverCode {

	public static void main(String[] args) {

		Queue<Integer> q = new Queue<>();

		q.add(12);
		q.add(24);
		q.add(34);
		q.add(56);

		System.out.println(q.peek());

		q.remove();
		q.remove();

		System.out.println(q.peek());

		q.add(89);

		System.out.println(q.peek());

		System.out.println(q.isEmpty());

		q.remove();
		q.remove();

		System.out.println(q.isEmpty());

		q.remove();
		System.out.println(q.isEmpty());
	}
}