import java.util.*;

class RemoveKConsecutiveEqual {

	public static void main(String[] args) {

		String[] s = {"abcd", "deeedbbcccbdaa", "pbbcggttciiippooaais", "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy"};
		int[] k = {2, 3, 2, 4};

		for (int i = 0; i < s.length; i++) System.out.println(removeDup(s[i], k[i]));
		System.out.println();
		for (int i = 0; i < s.length; i++) System.out.println(removeDup2(s[i], k[i]));
	}


	// Stack based solution, O(N) - worst case 2 pass with O(N) space

	static String removeDup(String s, int k) {

		Stack<Elem> stk = new Stack<>();

		for (char c : s.toCharArray()) {

			if (!stk.isEmpty() && stk.peek().c == c) {

				if (stk.peek().freq == k - 1) stk.pop();
				else stk.peek().freq++;

			} else stk.push(new Elem(c));
		}

		StringBuilder op = new StringBuilder();

		while (!stk.isEmpty()) {

			Elem curr = stk.pop();
			while (curr.freq-- > 0) op.append(curr.c);
		}

		return op.reverse().toString();
	}



	// Simple StringBuilder solution, O(N), - uses O(N) space, but more efficient than previous

	static String removeDup2(String s, int k) {

		StringBuilder op = new StringBuilder(s);
		int[] freq = new int[s.length()];

		for (int i = 0; i < op.length(); i++) {

			if (i == 0 || op.charAt(i) != op.charAt(i - 1)) freq[i] = 1;
			else {

				freq[i] = freq[i - 1] + 1;

				if (freq[i] == k) {

					op.delete(i - k + 1, i + 1);
					i -= k;
				}
			}
		}

		return op.toString();
	}

}

class Elem {

	char c;
	int freq;

	Elem(char c) {

		this.c = c;
		freq = 1;
	}
}