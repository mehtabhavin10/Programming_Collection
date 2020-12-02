/*

https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3491/

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/



Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"


Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

*/

class Solution {
    public String removeDuplicateLetters(String s) {

        char[] chars = s.toCharArray();

        int[] lastIndex = new int[26];
        for (int i = 0; i < chars.length; i++) lastIndex[chars[i] - 'a'] = i;


        boolean[] used = new boolean[26];

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {

            // if the current character has been used, skip it
            if (used[chars[i] - 'a']) continue;

            // if the current character is smaller than the last character in StringBuilder (mark it as c)
            // and the last index of c is larger than i, it means we can use it later,
            // so we delete it(c) and mark used as false

            while (ans.length() > 0 && ans.charAt(ans.length() - 1) > chars[i] && lastIndex[ans.charAt(ans.length() - 1) - 'a'] > i) {

                used[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }

            ans.append(chars[i]);
            used[chars[i] - 'a'] = true;
        }

        return ans.toString();
    }
}