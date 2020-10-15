import java.util.*;

class MinPlatforms {

	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		System.out.println(getMinPlatforms(arr, dep));
	}

	static int getMinPlatforms(int[] a, int[] d) {

		int n = a.length;

		Arrays.sort(a);
		Arrays.sort(d);

		int i = 0, j = 0, plat = 0, op = 0;

		while (i < n && j < n) {

			if (a[i] <= d[j]) {

				plat++;
				i++;

			} else {

				plat--;
				j++;
			}

			if (plat > op) op = plat;
		}

		return op;
	}
}