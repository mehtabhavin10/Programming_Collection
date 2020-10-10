import java.util.*;

class ExcelColNo {

	public static void main(String[] args) {

		String col = "CDA";

		int colNo = strToCol(col);

		System.out.println(colNo);

		String op = colToStr(colNo);

		System.out.println(op);
	}

	static int strToCol(String s) {

		int op = 0;

		for (char c : s.toCharArray()) {

			op *= 26;
			op += c - 'A' + 1;
		}

		return op;
	}

	static String colToStr(int n) {

		StringBuilder op = new StringBuilder("");

		while (n > 0) {

			int tmp = n % 26;

			if (tmp == 0) {

				op.append("Z");
				n = (n / 26) - 1;

			} else {

				op.append((char)((tmp - 1) + 'A'));
				n /= 26;
			}
		}

		return op.reverse().toString();
	}
}