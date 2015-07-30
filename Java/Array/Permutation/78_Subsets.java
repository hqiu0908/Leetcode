/*

Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        // Sort the array first to get a non-descending order
        Arrays.sort(nums);
        subsetsHelper(results, list, nums, 0);
        
        return results;
    }
    
    private void subsetsHelper(List<List<Integer>> results, 
        List<Integer> list, int[] nums, int start) {
        results.add(new ArrayList<Integer>(list));
        
        // The start position makes sure the set is in non-descending order 
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            // For the current level in the recursive tree, the next set 
            // starts from the next position after i
            subsetsHelper(results, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
