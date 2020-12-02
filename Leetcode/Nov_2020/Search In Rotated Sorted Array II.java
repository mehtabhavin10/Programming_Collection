/*

https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3537/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

*/

class Solution {
    public boolean search(int[] nums, int target) {

        int l = 0, h = nums.length - 1, mid;

        while (l <= h) {

            mid = (l + h) >>> 1;

            if (nums[mid] == target || nums[l] == target || nums[h] == target) return true;

            if (nums[l] < nums[mid]) {

                if (nums[l] < target && target < nums[mid]) h = mid - 1;
                else l = mid + 1;

            } else if (nums[mid] < nums[h]) {

                if (nums[mid] < target && target < nums[h]) l = mid + 1;
                else h = mid - 1;

            } else l++;
        }

        return false;
    }
}