import java.util.*;

class RomanInteger {

	public static void main(String[] args) {

		String ip = "MCMXCIV";

		int op = romanToInt(ip); // 1994

		System.out.println(op);
		System.out.println(intToRoman(op));
	}

	static int romanToInt(String s) {

		int op = 0, curr = 0, prev = 0;

		for (char c : s.toCharArray()) {

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



	static String intToRoman(int num) {

		int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romanNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		int i = 0;
		StringBuilder sb = new StringBuilder();

		while (num > 0) {

			while (num >= numbers[i]) {

				sb.append(romanNums[i]);
				num -= numbers[i];
			}
			i++;
		}

		return sb.toString();
	}
}