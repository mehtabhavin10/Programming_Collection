/*

https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3536/

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"


Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].

*/
class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();

        int n = 0;
        StringBuilder op = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) n = n * 10 + (c - '0');
            else if (c == '[') {

                numStk.push(n);
                strStk.push(op);
                n = 0;
                op = new StringBuilder();

            } else if (c == ']') {

                StringBuilder tmp = op;
                int times = numStk.pop();
                op = strStk.pop();

                while (times-- > 0) op.append(tmp);

            } else op.append(c);
        }

        return op.toString();
    }
}