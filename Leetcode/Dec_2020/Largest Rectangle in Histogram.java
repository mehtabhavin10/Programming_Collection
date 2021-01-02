/*

https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3587/


Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.




Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area = 10 unit.



Example:

Input: [2,1,5,6,2,3]
Output: 10

*/

class Solution {
	public int largestRectangleArea(int[] a) {


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