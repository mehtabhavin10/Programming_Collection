import java.util.*;

class WordBreak {

	public static void main(String[] args) {

		String[] dict = {"mobile", "samsung", "sam", "sung",
		                 "man", "mango", "icecream", "and",
		                 "go", "i", "love", "ice", "cream"
		                };

		String s = "iloveicecreamandmango";
		// String s = "ilovesamsungmobile";

		checkWord(dict, s);
	}


	// Backtracking to find all forming words

	static void checkWord(String[] dict, String s) {

		Set<String> set = new HashSet<>();
		for (String str : dict) set.add(str);

		checkWordRecursive(set, s, s.length(), "");
	}

	static void checkWordRecursive(Set<String> set, String s, int n, String op) {

		for (int i = 1; i <= n; i++) {

			String prefix = s.substring(0, i);

			if (set.contains(prefix)) {

				if (i == n) {

					op += prefix;
					System.out.println(op);
					return;
				}

				checkWordRecursive(set, s.substring(i), n - i, op + prefix + " ");
			}
		}
	}
}