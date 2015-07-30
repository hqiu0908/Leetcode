/*

Given a sorted array of integers, find the starting and ending position of a
given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] results = new int[2];
        results[0] = -1;
        results[1] = -1;

        if (nums == null || nums.length == 0) {
            return results;
        }
        
        // Search for the left bound
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // Keep searching for the first occurrence
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            results[0] = start;
        } else if (nums[end] == target) {
            results[0] = end;
        } else {
            return results;
        }
        
        // Search for the right bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // Keep searching for the last occurrence
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[end] == target) {
            results[1] = end;
        } else if (nums[start] == target) {
            results[1] = start;
        }
        
        return results;
    }
}
