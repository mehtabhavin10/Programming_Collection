class RainWaterTrapping {

	public static void main(String[] args) {

		int ip[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(getWater(ip));
		System.out.println(getWater2(ip));
	}


	// O(N), O(N)

	static int getWater(int[] a) {

		int n = a.length;
		if (n <= 2) return 0;

		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = a[0];
		for (int i = 1; i < n; i++) left[i] = Math.max(a[i], left[i - 1]);

		right[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) right[i] = Math.max(a[i], right[i + 1]);

		int water = 0;
		for (int i = 0; i < n; i++) water += Math.min(left[i], right[i]) - a[i];

		return water;
	}


	// O(N), O(1)

	static int getWater2(int[] a) {

		int n = a.length;
		if (n <= 2) return 0;

		int leftMax = 0, rightMax = 0, l = 0, h = n - 1, water = 0;

		while (l <= h) {

			if (a[l] < a[h]) {

				leftMax = Math.max(a[l], leftMax);
				water += leftMax - a[l++];

			} else {

				rightMax = Math.max(a[h], rightMax);
				water += rightMax - a[h--];
			}
		}

		return water;
	}
}