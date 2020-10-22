import java.util.*;

class CombinationSum {

	public static void main(String[] args) {

		int[] ip = {6, 6, 6, 4, 4, 8, 2, 4, 2, 4, 6, 8};
		int k = 8;

		getCombinations(ip, k);
	}

	static void getCombinations(int[] arr, int k) {

		quickSort(arr, 0, arr.length - 1);

		arr = Arrays.stream(arr).distinct().toArray();

		LinkedList<Integer> sol = new LinkedList<>();

		solve(arr, k, sol, 0);
	}


	static void solve(int[] arr, int k, LinkedList<Integer> sol, int index) {

		if (k < 0) return;

		if (k == 0) {

			System.out.println(sol);
			return;
		}

		while (index < arr.length && k - arr[index] >= 0) {

			sol.add(arr[index]);
			solve(arr, k - arr[index], sol, index);
			sol.removeLast();
			index++;
		}
	}


	static void quickSort(int[] a, int l, int h) {

		if (l < h) {

			int loc = sort(a, l, h);
			quickSort(a, l, loc - 1);
			quickSort(a, loc + 1, h);
		}
	}

	static int sort(int[] a, int l, int h) {

		int i = l, j = h, tmp, pivot = a[l];

		while (i < j) {

			if (a[i] <= pivot) i++;
			if (a[j] >= pivot) j--;

			if (i < j) {

				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}

		tmp = a[l];
		a[l] = a[j];
		a[j] = tmp;

		return j;
	}
}