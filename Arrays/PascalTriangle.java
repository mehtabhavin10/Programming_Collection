import java.util.*;

class PascalTriangle {

	public static void main(String[] args) {

		int n = 10;
		printPascalTri(n);
	}

	static void printPascalTri(int n) {

		if (n <= 0) return;
		if (n == 1) System.out.println(1);

		List<Integer> prev = new ArrayList<>();
		prev.add(1);

		List<Integer> curr = new ArrayList<>();

		for (int i = 2; i <= n; i++) {

			curr.add(1);

			if (prev.size() >= 2)
				for (int j = 1; j < prev.size(); j++)
					curr.add(prev.get(j) + prev.get(j - 1));

			curr.add(1);

			for (int j : curr) System.out.print(j + " ");
			System.out.println();

			prev = curr;
			curr = new ArrayList<>();
		}

	}
}

// Time: O(n^2), Space O(1)