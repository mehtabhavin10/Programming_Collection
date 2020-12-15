/*


https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3565/


Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.


*/


class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> op = new ArrayList<>();
        solve(s, op, new LinkedList<>(), 0);
        return op;
    }

    void solve(String s, List<List<String>> op, LinkedList<String> ans, int l) {

        if (l == s.length()) {

            op.add((List)ans.clone());
            return;
        }

        for (int h = l; h < s.length(); h++) {

            if (!isPalindrome(s, l, h)) continue;
            ans.add(s.substring(l, h + 1));
            solve(s, op, ans, h + 1);
            ans.removeLast();
        }
    }

    boolean isPalindrome(String s, int l, int h) {

        while (l < h && s.charAt(l) == s.charAt(h)) {
            l++;
            h--;
        }

        return l >= h;
    }
}