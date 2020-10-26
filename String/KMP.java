class KMP {

	public static void main(String[] args) {

		String[][] ip = {
			{"ABABDABACDABABCABAB", "ABABCABAB"},
			{"hello", "ll"},
			{"aaaaa", "bba"},
			{"",  ""},
			{"GEEKS FOR GEEKS", "FOR"}
		};

		for (String[] str : ip) System.out.println(search(str[0], str[1]));
	}


	static int search(String text, String pattern) {

		char[] txt = text.toCharArray();
		char[] pat = pattern.toCharArray();

		int n = txt.length, m = pat.length;

		if (n == 0 && m == 0) return 0;
		if (n < m) return -1;


		int[] lps = getLPS(pat, m);

		int i = 0, j = 0;

		while (i < n) {

			if (pat[j] == txt[i]) {

				if (j == m - 1) return i - m + 1;
				i++;
				j++;

			} else if (j > 0) j = lps[j - 1];
			else i++;
		}

		return -1;
	}


	static int[] getLPS(char[] pat, int m) {

		int[] lps = new int[m];
		lps[0] = 0;

		int i = 1, j = 0;

		while (i < m) {

			if (pat[i] == pat[j]) {

				lps[i] = j + 1;
				i++;
				j++;

			} else if (j > 0) j = lps[j - 1];
			else lps[i++] = 0;
		}

		return lps;
	}
}