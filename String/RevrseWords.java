import java.util.*;

class RevrseWords {

	public static void main(String[] args) {

		String[] ip = {
			"  Bob    Loves  Alice   ",
			"a good   example",
			"  hello world  ",
			"the sky is blue"
		};

		for (String s : ip) System.out.println(reverseWords(s));
	}



	static String reverseWords(String s) {

		String[] str = s.split(" ");

		StringBuilder op = new StringBuilder();

		for (int i = str.length - 1; i >= 0; i--) if (!str[i].equals("")) op.append(str[i] + " ");

		return op.toString().trim();
	}
}