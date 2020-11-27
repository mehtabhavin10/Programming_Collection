/*

https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3544/

Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is less than or equal to k.



Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105

*/
class Solution {
    public int longestSubstring(String s, int k) {

        return getMaxLength(0, s.length() - 1, s.toCharArray(), k);
    }

    int getMaxLength(int l, int h, char[] s, int k) {

        int[] freq = new int[26];

        for (int i = l; i <= h; i++) freq[s[i] - 'a']++;

        for (int i = l; i <= h; i++)
            if (freq[s[i] - 'a'] < k)
                return Math.max(getMaxLength(l, i - 1, s, k), getMaxLength(i + 1, h, s, k));

        return h - l + 1;
    }
}