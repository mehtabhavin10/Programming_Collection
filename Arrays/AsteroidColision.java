import java.util.*;

class AsteroidColision {

	public static void main(String[] args) {

		int[][] ip = {
			{5, 10, -5},
			{8, -8},
			{10, 2, -5},
			{ -2, -1, 1, 2}
		};

		for (int[] i : ip) {
			for (int e : afterCollision(i)) System.out.print(e + " ");
			System.out.println();
		}
	}


	static int[] afterCollision(int[] a) {

		if (a.length <= 1) return a;
		Stack<Integer> stk = new Stack<>();

		for (int i : a) {

			boolean insert = true;

			while (!stk.isEmpty() && stk.peek() > 0 && i < 0) {

				if (-i > stk.peek()) stk.pop();
				else {

					if (-i == stk.peek()) stk.pop();
					insert = false;
					break;
				}
			}

			if (insert) stk.push(i);
		}

		int[] op = new int[stk.size()];
		int i = op.length - 1;

		while (!stk.isEmpty()) op[i--] = stk.pop();

		return op;
	}

}