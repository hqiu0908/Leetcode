/*

Given a collection of numbers that might contain duplicates, return all possible
unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<Integer>();
        boolean[] visited = new boolean[nums.length];
        
        permuteHelper(nums, result, list, visited);
        
        return result;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> result,
        List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<Integer>(list));
            return;
        }
            
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            
            visited[i] = true;
            list.add(nums[i]);
            permuteHelper(nums, result, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}