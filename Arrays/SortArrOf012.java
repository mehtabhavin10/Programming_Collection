import java.util.*;

class SortArrOf012 {

	public static void main(String[] args) {

		int[] ip = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortArr(ip);
	}

	static void sortArr(int[] a) {

		int zero = 0, one = 0, two = 0;

		for (int i : a) {

			switch (i) {
			case 0 : zero++; break;
			case 1 : one++; break;
			case 2 : two++;
			}
		}

		for (int i = 0; i < a.length; i++) {

			if (zero-- > 0) a[i] = 0;
			else if (one-- > 0) a[i] = 1;
			else a[i] = 2;

			System.out.print(a[i] + " ");
		}
	}
}

