/*


https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3518/


Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.



Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1


Constraints:

1 <= s.length <= 500
s contains only lowercase English letters.

*/
class Solution {
    public int maxPower(String s) {

        if (s.equals("")) return 0;

        int op = 1;
        char[] ip = s.toCharArray();

        for (int i = 1; i < ip.length; i++) {

            int tmp = 1;
            while (i < ip.length && ip[i] == ip[i - 1]) {
                tmp++;
                i++;
            }

            op = Math.max(op, tmp);
        }

        return op;
    }
}