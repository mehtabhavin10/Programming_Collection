class Atoi {

	public static void main(String[] args) {

		String[] ip = {"   -42",
		               "4193 with words",
		               "words and 987",
		               "-91283472332"
		              };

		for (String s : ip) System.out.println(convert(s));
	}


	static int convert(String s) {

		char[] ip = s.toCharArray();
		int sign = 1, op = 0, i = 0;

		while (i < ip.length && ip[i] == ' ') i++;

		if (i < ip.length && (ip[i] == '+' || ip[i] == '-')) {

			if (ip[i] == '-') sign = -1;
			i++;
		}


		while (i < ip.length && (ip[i] >= '0' && ip[i] <= '9')) {

			if (op > Integer.MAX_VALUE / 10 || (op == Integer.MAX_VALUE / 10 && ip[i] - '0' > 7)) {

				if (sign == 1) return Integer.MAX_VALUE;
				else return Integer.MIN_VALUE;
			}

			op = (10 * op) + (ip[i++] - '0');
		}

		return sign * op;
	}
}