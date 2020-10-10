class Power {

	public static void main(String[] args) {

		// Power in O(LogN)
		System.out.println(pow(2, 5));

		// Power of float + negative pow
		System.out.println(pow(4.0f, -1));
	}

	static int pow(int x, int y) {

		if (y == 0) return 1;

		int tmp = pow(x, y / 2);

		if ((y & 1) == 0) return tmp * tmp;
		return x * tmp * tmp;
	}



	static float pow(float x, int y) {

		if (y == 0) return 1;

		float tmp = pow(x, y / 2);

		if ((y & 1) == 0) return tmp * tmp;
		else if (y > 0) return x * tmp * tmp;
		return (tmp * tmp) / x;
	}
}