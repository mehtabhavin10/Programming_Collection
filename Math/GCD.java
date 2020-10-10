class GCD {

	public static void main(String[] args) {

		System.out.println(getGCD(21, 66));
	}

	static int getGCD(int a, int b) {

		if (b == 0) return a;
		return getGCD(b, a % b);
	}
}