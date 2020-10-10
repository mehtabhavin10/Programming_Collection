class TrailingZerosInFact {

	public static void main(String[] args) {

		System.out.println(getTrailZeros(5));
	}

	static int getTrailZeros(int n) {

		int op = 0;
		for (int i = 5; n / i >= 1; i *= 5) op += (n / i);
		return op;
	}
}