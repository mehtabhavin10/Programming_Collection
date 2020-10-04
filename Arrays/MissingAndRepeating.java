class MissingAndRepeating {

	public static void main(String[] args) {

		// int[] ip = {4, 3, 6, 2, 1, 1};
		int[] ip = {3, 1, 3};
		findMissingAndRepeating(ip);
	}

	static void findMissingAndRepeating(int[] a) {

		for (int i : a) {

			int index = Math.abs(i);

			if (a[index - 1] < 0) System.out.print("Repeat: " + index);
			else a[index - 1] = -a[index - 1];
		}

		for (int i = 0; i < a.length; i++) {

			if (a[i] >= 0) {
				System.out.println("\nMissing: " + (i + 1));
				return;
			}
		}
	}
}