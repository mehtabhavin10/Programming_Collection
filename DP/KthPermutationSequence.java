import java.util.*;

class KthPermutationSequence {

	public static void main(String[] args) {

		System.out.println(getSequence(3, 3));
		System.out.println(getSequence(4, 9));
		System.out.println(getSequence(3, 4));
	}

	static String getSequence(int n, int k) {

		int[] fact = new int[n + 1];
		List<Integer> num = new ArrayList<>();

		fact[0] = 1;

		for (int i = 1; i <= n; i++) {

			fact[i] = fact[i - 1] * i;
			num.add(i);
		}

		k--;
		StringBuilder op = new StringBuilder();

		for (int i = 1; i <= n; i++) {

			int index = (k / fact[n - i]);
			op.append(num.get(index));
			num.remove(index);
			k -= index * fact[n - i];
		}

		return op.toString();
	}
}