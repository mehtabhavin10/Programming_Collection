class RomanInt {

	public static void main(String[] args) {

		String[] roman = {
			"III",
			"IV",
			"IX",
			"LVIII",
			"MCMXCIV"
		};

		int[] ints = new int[roman.length];

		for (int i = 0; i < roman.length; i++) {
			ints[i] = romanToInt(roman[i]);
			System.out.println(roman[i] + " -> " + ints[i]);
		}

		System.out.println();
		for (int i : ints) System.out.println(i + " -> " + intToRoman(i));
	}


	static int romanToInt(String r) {

		int op = 0, curr = 0, prev = 0;

		for (char c : r.toCharArray()) {

			curr = valueOf(c);

			if (curr > prev) {

				op += (curr - prev);
				op -= prev;

			} else op += curr;

			prev = curr;
		}

		return op;
	}

	static int valueOf(char c) {

		switch (c) {

		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;

		}

		return 0;
	}


	static String intToRoman(int n) {

		StringBuilder op = new StringBuilder();

		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romanNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		int i = 0;

		while (n > 0) {

			while (n >= nums[i]) {

				op.append(romanNums[i]);
				n -= nums[i];
			}
			i++;
		}

		return op.toString();
	}
}