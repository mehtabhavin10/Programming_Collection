class RabinKarp {

	public static void main(String[] args) {

		String[][] ip = {
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

		int n = txt.length, m = pat.length, hashTxt = 0, hashPat = 0;

		if (n == 0 && m == 0) return 0;
		if (n < m) return -1;


		for (int i = 0; i < m; i++) {

			hashPat += pat[i] - 'a';
			hashTxt += txt[i] - 'a';
		}


		for (int i = 0; i <= n - m; i++) {

			if (hashTxt == hashPat) {

				int j;
				for (j = 0; j < m; j++) if (txt[i + j] != pat[j]) break;

				if (j == m) return i;
			}

			if (i < n - m) {

				hashTxt -= txt[i] - 'a';
				hashTxt += txt[i + m] - 'a';
			}
		}

		return -1;
	}
}