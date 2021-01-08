/*


https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/


Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) return s.length();

        char[] ip = s.toCharArray();
        boolean[] chars = new boolean[127];
        int l = 0, h = 0, max = 0;

        while (h < ip.length) {

            if (chars[ip[h]]) {

                while (l < h && ip[l] != ip[h]) {

                    chars[ip[l]] = false;
                    l++;
                }
                l++;
            }

            chars[ip[h]] = true;
            max = Math.max(max, h - l + 1);
            h++;
        }

        return max;
    }
}