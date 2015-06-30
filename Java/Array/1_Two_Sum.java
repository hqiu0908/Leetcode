/*

Given an array of integers, find two numbers such that they add up to a specific
target number.

The function twoSum should return indices of the two numbers such that they add
up to the target, where index1 must be less than index2. Please note that your
returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        
        if (nums == null || nums.length == 0) {
            results[0] = 0;
            results[1] = 0;
            return results;
        }
        
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            
            if (hashmap.containsKey(key)) {
                int val = hashmap.get(key);
                results[0] = val + 1;
                results[1] = i + 1;
                break;
            }
            
            hashmap.put(nums[i], i);
        }
        
        return results;
    }
}


