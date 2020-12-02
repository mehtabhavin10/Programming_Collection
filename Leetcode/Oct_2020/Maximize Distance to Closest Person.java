/*

https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3512/


You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to the closest person.



Example 1:


Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: seats = [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Example 3:

Input: seats = [0,1]
Output: 1


Constraints:

2 <= seats.length <= 2 * 104
seats[i] is 0 or 1.
At least one seat is empty.
At least one seat is occupied.

*/
class Solution {
    public int maxDistToClosest(int[] seats) {


        int max = 0, occupied = -1;

        for (int i = 0; i < seats.length; i++) {

            if (seats[i] == 1) {
                /* If this is the first occupied seat from the left, "i" is the max
                   distance so far meaning we could seat at the very first seat */
                if (occupied == -1) max = i;

                /* Otherwise, if there is at least one empty seat between two
                   successive occupied seats, we can try to sit in the middle */
                else if (i > occupied + 1) {
                    int mid = (occupied + i) >> 1;
                    max = Math.max(max, mid - occupied);
                }

                /* Mark this seat as the last occupied */
                occupied = i;
            }
        }

        /* If there are lots of empty seats at the end, then we may be
           able to sit at the very last seat */
        return Math.max(max, seats.length - occupied - 1);
    }
}