import java.util.*;

class LargestRectInHisto {

	public static void main(String[] args) {

		int[] ip = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(getMaxArea(ip));
	}

	static int getMaxArea(int[] a) {

		int max = 0, i = 0, tmp, curr;
		Stack<Integer> stk = new Stack<>();


		while (i < a.length) {

			if (stk.isEmpty() || a[i] > a[stk.peek()]) stk.push(i++);
			else {

				curr = stk.pop();
				tmp = a[curr] * (stk.isEmpty() ? i : i - stk.peek() - 1);
				max = Math.max(max, tmp);
			}
		}

		while (!stk.isEmpty()) {

			curr = stk.pop();
			tmp = a[curr] * (stk.isEmpty() ? i : i - stk.peek() - 1);
			max = Math.max(max, tmp);
		}

		return max;
	}
}