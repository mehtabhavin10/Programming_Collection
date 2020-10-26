class LongestCommonPrefix {

	public static void main(String[] args) {

		String[][] ip = {
			{"flower", "flow", "flight"},
			{"dog", "racecar", "car"},
			{},
			{"one"},
			{"one", "one", "one"}
		};


		for (String[] str : ip) System.out.println(getLCP(str));
	}

	static String getLCP(String[] str) {

		if (str.length == 0) return "";
		if (str.length == 1) return str[0];

		String op = "";
		int n = str[0].length();

		for (int i = 0; i < n; i++) {

			char c = str[0].charAt(i);

			for (int j = 1; j < str.length; j++)
				if (str[j].length() <= i || str[j].charAt(i) != c) return op;

			op += c;
		}

		return op;
	}
}