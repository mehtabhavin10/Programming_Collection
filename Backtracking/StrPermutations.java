class StrPermutations {

	public static void main(String[] args) {

		String s = "abc";

		printPerm(s.toCharArray(), 0, s.length() - 1);
	}

	static void printPerm(char[] s, int l, int h) {

		if (l == h) System.out.println(new String(s));
		else {

			for (int i = l; i <= h; i++) {

				char tmp = s[i];
				s[i] = s[l];
				s[l] = tmp;

				printPerm(s, l + 1, h);

				tmp = s[i];
				s[i] = s[l];
				s[l] = tmp;
			}
		}
	}
}