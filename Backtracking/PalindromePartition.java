import java.util.*;

class PalindromePartition {

	public static void main(String[] args) {

		String s = "ababbbabbababa";

		for (List<String> ans : partition(s)) {

			for (String str : ans) System.out.print(str + " ");
			System.out.println();
		}
	}

	static List<List<String>> partition(String s) {

		List<List<String>> op = new ArrayList<>();
		solve(s, op, new LinkedList<>(), 0);
		return op;
	}


	static void solve(String s, List<List<String>> op, LinkedList<String> ans, int l) {

		if (l == s.length()) {

			op.add((List)ans.clone());
			return;
		}

		for (int h = l; h < s.length(); h++) {

			if (!isPalindrome(s, l, h)) continue;
			ans.add(s.substring(l, h + 1));
			solve(s, op, ans, h + 1);
			ans.removeLast();
		}
	}


	static boolean isPalindrome(String s, int l, int h) {

		while (l < h && s.charAt(l) == s.charAt(h)) {
			l++;
			h--;
		}

		return l >= h;
	}
}