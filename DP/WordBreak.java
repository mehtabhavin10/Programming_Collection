package DP;

import DS.TrieDS.Trie;
import java.util.*;

// https://leetcode.com/problems/word-break/
// https://leetcode.com/problems/word-break-ii/


class WordBreak {

	public static void main(String[] args) {

		// String[] dict = {"mobile", "samsung", "sam", "sung",
		//                  "man", "mango", "icecream", "and",
		//                  "go", "i", "love", "ice", "cream"
		//                 };

		String[] dict = {"cat", "cats", "and", "sand", "dog"};

		// String s = "iloveicecreamandmango";
		// String s = "ilovesamsungmobile";
		String s = "catsanddog";

		if (wordBreak(s, dict)) for (String i : checkWord(dict, s)) System.out.println(i);
		else System.out.println("Not Possible");
	}




	// Trie Based solution to obtains all possible answers!

	static List<String> checkWord(String[] dict, String s) {

		List<String> op = new ArrayList<>();
		if (s.equals("") || dict.length == 0) return op;

		Trie trie = new Trie();
		for (String str : dict) trie.insert(str);

		generate(trie, s, 0, s.length(), "", op);

		return op;
	}


	static void generate(Trie trie, String s, int index, int n, String sol, List<String> op) {

		if (index == n) {

			op.add(sol.trim());
			return;
		}

		for (int i = index + 1; i <= n; i++) {

			String tmp = s.substring(index, i);
			if (trie.search(tmp)) generate(trie, s, i, n, sol + " " + tmp, op);

		}
	}




	// DP Solution to only check whether answer exists or not!

	static public boolean wordBreak(String s, String[] wordDict) {


		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {

			String curr = s.substring(0, i);

			for (String word : wordDict) {

				if (curr.endsWith(word)) {

					dp[i] = dp[i - word.length()];
					if (dp[i]) break;
				}
			}
		}

		return dp[dp.length - 1];
	}
}