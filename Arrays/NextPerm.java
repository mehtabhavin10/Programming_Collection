
/*

1. Find largest index i, such that A[i] < A[i+1]
	If not found than no next greater possible!
2. Find largest index j, such that A[j] > A[i] & j>=i
3. Swap A[i], A[j]
4. Reverse A from i+1 to n



*/







class NextPerm {

	public static void main(String[] args) {

		int[] a = {1, 2, 3};	  // OP: 132
		// int[] a = {1, 1, 5};   // OP: 151
		// int[] a = {3, 2, 1};   // OP: 123
		// int[] a = {1};		  // OP: 1

		nextPerm(a);
		for (int i : a) System.out.print(i + " ");
	}

	static void nextPerm(int[] a) {

		int n = a.length;
		int l = -1;

		for (int i = n - 2; i >= 0; i--) {

			if (a[i] < a[i + 1]) {
				l = i;
				break;
			}
		}

		if (l == -1) {

			reverse(a, 0, n - 1);
			return;
		}

		int h = l + 1;

		for (int i = n - 1; i > l; i--) {

			if (a[i] > a[l]) {

				h = i;
				break;
			}
		}

		int tmp = a[l];
		a[l] = a[h];
		a[h] = tmp;

		reverse(a, l + 1, n - 1);
	}

	static void reverse(int[] a, int l, int h) {

		while (l < h) {

			int tmp = a[l];
			a[l] = a[h];
			a[h] = tmp;
			l++;
			h--;
		}
	}
}