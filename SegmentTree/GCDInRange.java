class GCDInRange {

	static int[] t;

	public static void main(String[] args) {

		// int[] ip = { 2, 3, 6, 9, 5};
		int n = 5;

		int[] ip = {2, 3, 60, 90, 50};

		t = new int[4 * n];
		build(ip, 1, 0, n - 1);

		// int index = 0;
		// for (int i : t) System.out.print((index++) + ": " + i + "\t");
		// System.out.println();

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++)
				System.out.println(i + ", " + j + ": " + findGCD(1, 0, n - 1, i, j));
		}

	}


	static int findGCD(int i, int l, int h, int s, int e) {

		if (s > e) return 0;
		if (s == l && e == h) return t[i];

		int mid = (l + h) >>> 1;

		return gcd(findGCD(2 * i, l, mid, s, Math.min(e, mid)),
		           findGCD(2 * i + 1, mid + 1, h, Math.max(s, mid + 1), e));
	}


	static void build(int[] a, int i, int s, int e) {

		if (s >= e) t[i] = a[s];
		else {

			int mid = (s + e) >>> 1;
			build(a, 2 * i, s, mid);
			build(a, 2 * i + 1, mid + 1, e);

			t[i] = gcd(t[2 * i], t[2 * i + 1]);
		}
	}


	static int gcd(int a, int b) {

		if (b > a) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (b == 0) return a;
		return gcd(b, a % b);
	}

}