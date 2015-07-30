/*

Given a collection of integers that might contain duplicates, nums, return all
possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        subsetsWithDupHelper(results, list, nums, 0);
        return results;
    }
    
    private void subsetsWithDupHelper(List<List<Integer>> results, 
        List<Integer> list, int[] nums, int start) {
        results.add(new ArrayList<Integer>(list));
        
        for (int i = start; i < nums.length; i++) {
            // Remove the duplicates
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDupHelper(results, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
