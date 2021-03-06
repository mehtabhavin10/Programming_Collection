import java.util.*;

class NextGreater {

	public static void main(String[] args) {

		int[] ip = { 11, 13, 21, 3 };

		for (int i : getNextGreater(ip)) System.out.print(i + " ");
	}

	static int[] getNextGreater(int[] a) {

		int[] op = new int[a.length];

		Stack<Integer> stk = new Stack<>();
		stk.push(0);

		for (int i = 1; i < a.length; i++) {

			while (!stk.isEmpty() && a[i] > a[stk.peek()]) op[stk.pop()] = a[i];
			stk.push(i);
		}

		while (!stk.isEmpty()) op[stk.pop()] = -1;

		return op;
	}
}