/*


https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3578/


Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.



Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1


Constraints:

1 <= n <= 231 - 1

*/

class Solution {
    public int nextGreaterElement(int n) {
        char [] num = (n + "").toCharArray();
        int i = -1;
        for (i = num.length - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                break;
            }
        }
        if (i == 0)
            return  -1;

        int x = num[i - 1], smallest = i;

        for (int j = i + 1; j < num.length; j++) {
            if (num[j] > x && num[j] <= num[smallest]) {
                smallest = j;

            }
        }
        swap(num, smallest, i - 1);
        reverse(num, i, num.length - 1);

        long val = Long.parseLong(new String(num));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
    public void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public void reverse(char[] num, int i, int j) {
        while (i < j) {
            char temp = num[i];
            num[i++] = num[j];
            num[j--] = temp;
        }
    }
}