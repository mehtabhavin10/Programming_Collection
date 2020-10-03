class MissingAndRepeating {

	public static void main(String[] args) {

		int[] ip = {4, 3, 6, 2, 1, 1};
		findMissingAndRepeating(ip);
	}

	static void findMissingAndRepeating(int[] a) {

		for (int i : a) {

			if (i < 0) System.out.print("Repeat: " + i);
			else a[i] = -1;
		}

		for (int i = )
		}
}