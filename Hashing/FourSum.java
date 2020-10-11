import java.util.*;

class FourSum {

	public static void main(String[] args) {

		int[] ip = { 10, 20, 30, 40, 1, 2 };
		int k = 91;
		getFourElem(ip, k);
	}

	static void getFourElem(int[] a, int k) {

		Map<Integer, int[]> map = new HashMap<>();
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {

			for (int j = i + 1; j < n; j++) {

				int sum = a[i] + a[j];

				if (map.containsKey(k - sum)) {

					int[] arr = map.get(k - sum);

					if (i != arr[0] && i != arr[1] && j != arr[0] && j != arr[1]) {

						System.out.println(a[arr[0]] + ", " + a[arr[1]] + ", " + a[i] + ", " + a[j]);
						return;
					}
				}

				map.put((a[i] + a[j]), new int[] {i, j});
			}
		}
	}
}