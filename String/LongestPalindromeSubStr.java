class LongestPalindromeSubStr {

	public static void main(String[] args) {

		String[] ip = {
			"forgeeksskeegfor",
			"Geeks",
			"babad",
			"cbbd",
			"ac"
		};

		for (String s : ip) System.out.println(getLongestPalSubstring(s));
	}


	static String getLongestPalSubstring(String s) {

		char[] ip = s.toCharArray();
		int start = 0, end = 0, n = ip.length;

		for (int i = 0; i < n - 1; i++) {

			int oddLen = check(ip, n, i, i);
			int evenLen = check(ip, n, i, i + 1);

			int max = Math.max(oddLen, evenLen);

			if (max > (end - start + 1)) {

				start = i - ((max - 1) / 2);
				end = i + (max / 2);
			}
		}

		return s.substring(start, end + 1);
	}


	static int check(char[] ip, int n, int l, int h) {

		while (l >= 0 && h < n && ip[l] == ip[h]) {
			l--;
			h++;
		}
		return h - l - 1;
	}
}