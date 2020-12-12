/*

https://leetcode.com/problems/interleaving-string/



Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.



Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true


Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lower-case English letters.

*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {


        if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) return true;
        if (s3.length() != s1.length() + s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        char[] c = s3.toCharArray();

        int n = a.length, m = b.length;
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) if (b[j - 1] == c[j - 1]) dp[0][j] = dp[0][j - 1];
        for (int i = 1; i <= n; i++) if (a[i - 1] == c[i - 1]) dp[i][0] = dp[i - 1][0];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (a[i - 1] == c[i + j - 1] && b[j - 1] == c[i + j - 1]) dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                else if (a[i - 1] == c[i + j - 1]) dp[i][j] = dp[i - 1][j];
                else if (b[j - 1] == c[i + j - 1]) dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[n][m];
    }
}