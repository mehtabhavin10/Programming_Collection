// package DP;

// import DS.TrieDS.Trie;
import java.util.*;

class WordBreak {

	public static void main(String[] args) {

		String[] dict = {"mobile", "samsung", "sam", "sung",
		                 "man", "mango", "icecream", "and",
		                 "go", "i", "love", "ice", "cream"
		                };

		String s = "iloveicecreamandmango";
		// String s = "ilovesamsungmobile";

		for (String i : checkWord(dict, s)) System.out.println(i);
		// else System.out.println("Not Possible");
	}


	// DP

	static List<String> checkWord(String[] dict, String s) {

		List<String> op = new ArrayList<>();
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {

			String curr = s.substring(0, i);

			for (String str : dict) {

				if (curr.endsWith(str)) {

					dp[i] = dp[i - str.length()];
					if (dp[i]) {

						op.add(str);
						break;
					}
				}
			}
		}

		return op;
	}
}