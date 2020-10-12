import java.util.*;

class LongestSubStrWithoutReapeat {

	public static void main(String[] args) {

		// String ip = "abcabcbb";
		// String ip = "bbbbb";
		// String ip = "pwwkew";
		String ip = "abba";

		System.out.println(getLongestSubstr(ip));
	}

	static int getLongestSubstr(String s) {

		if (s == null || s.equals("")) return 0;

		int op = 1;
		Map<Character, Integer> map = new HashMap<>();

		int l = 0, h = 0;

		for (char c : s.toCharArray()) {

			if (map.containsKey(c)) {

				op = Math.max(op, h - l);
				l = Math.max(l, map.get(c) + 1);
			}

			map.put(c, h++);
		}

		return Math.max(op, h - l);
	}
}