/*

https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3542/

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

*/

class Solution {
    public int calculate(String s) {

        if (s.equals("")) return 0;

        char[] ip = s.toCharArray();
        int curr = 0, ans = 0, prev = 0;
        char op = '+';

        for (int i = 0; i < ip.length; i++) {

            if (Character.isDigit(ip[i])) curr = curr * 10 + (ip[i] - '0');
            if (!Character.isDigit(ip[i]) && ip[i] != ' ' || i == ip.length - 1) {

                if (op == '+') {

                    ans += prev;
                    prev = curr;

                } else if (op == '-') {

                    ans += prev;
                    prev = -curr;

                } else if (op == '*') prev *= curr;
                else if (op == '/') prev /= curr;

                op = ip[i];
                curr = 0;
            }
        }

        ans += prev;

        return ans;
    }
}