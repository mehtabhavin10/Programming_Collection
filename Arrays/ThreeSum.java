import java.util.*;

class ThreeSum {

	public static void main(String[] args) {

		int[] ip = { 1, 4, 45, 6, 10, 8 };
		int sum = 22;

		findTiplet(ip, sum);
		findTiplet2(ip, sum);
	}


	// Two Pointer Approach O(N^2), O(1)

	static void findTiplet(int[] a, int k) {

		Arrays.sort(a);

		for (int i = 0; i < a.length - 2; i++) {

			int l = i + 1, h = a.length - 1, tmp;

			while (l < h) {

				tmp = a[i] + a[l] + a[h];

				if (tmp == k) {

					System.out.println(a[i] + " " + a[l] + " " + a[h]);
					return;
				}

				if (tmp < k) l++;
				else h--;
			}
		}

		System.out.println("Not Found!");
	}


	// Hashing Approach O(N^2), O(1)

	static void findTiplet2(int[] a, int k) {

		for (int i = 0; i < a.length - 2; i++) {

			Set<Integer> set = new HashSet<>();

			for (int j = i + 1; j < a.length; j++) {

				if (set.contains(k - a[i] - a[j])) {

					System.out.println(a[i] + " " + a[j] + " " + (k - a[i] - a[j]));
					return;
				}

				set.add(a[j]);
			}
		}

		System.out.println("Not Found!");
	}
}