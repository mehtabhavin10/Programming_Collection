/*

https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

Approach: https://www.geeksforgeeks.org/maximum-xor-of-two-numbers-in-an-array-set-2/


Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

Follow up: Could you do this in O(n) runtime?

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [0]
Output: 0
Example 3:

Input: nums = [2,4]
Output: 6
Example 4:

Input: nums = [8,10,2]
Output: 10
Example 5:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1

*/


class Solution {
    public int findMaximumXOR(int[] nums) {
        
        int n = nums.length;
        if(n==0) return 0;
       
        Node root = new Node();
        for(int i : nums) insert(root, i);
        
        int maxXor = 0;
        
        for(int num : nums) {
            
            int curr = 0;
            int m = (int) Math.pow(2, 30);
            Node tmp = root;
            
            for(int i=30;i>=0;i--) {
                
                int b = (num >> i) & 1;
                
                if(b == 0) {
                    
                    if(tmp.right != null) {
                        
                        curr += m;
                        tmp = tmp.right;
                        
                    } else tmp = tmp.left;
                
                } else {
                    
                    if(tmp.left != null) {
                        
                        curr += m;
                        tmp = tmp.left;
                        
                    } else tmp = tmp.right;
                }
                
                m/=2;
            }
            
            maxXor = Math.max(maxXor, curr);
        }
        
        return maxXor;
    }
    
    
    void insert(Node root, int num) {
        
        Node tmp = root;
        
        for(int i=30;i>=0;i--) {
            
            int b = (num >> i) & 1;
            
            if(b == 0) {
                
                if(tmp.left == null) tmp.left = new Node();
                tmp = tmp.left;
            
            } else {
                
                if(tmp.right == null) tmp.right = new Node();
                tmp = tmp.right;
            }
        }
    }
}

class Node {    Node left, right;    }