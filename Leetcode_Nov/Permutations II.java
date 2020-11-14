/*

https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3528/

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

*/
class Solution {

    Set<List<Integer>> op;

    public List<List<Integer>> permuteUnique(int[] nums) {

        op = new HashSet<>();

        permute(nums, 0, nums.length);

        return new ArrayList<>(op);
    }

    void permute(int[] a, int l, int h) {

        if (l >= h) {
            op.add(getList(a));
            return;
        }

        for (int i = l; i < h; i++) {

            int t = a[i];
            a[i] = a[l];
            a[l] = t;

            permute(a, l + 1, h);

            t = a[i];
            a[i] = a[l];
            a[l] = t;
        }
    }

    List<Integer> getList(int[] a) {

        List<Integer> list = new ArrayList<>();
        for (int i : a) list.add(i);
        return list;
    }
}