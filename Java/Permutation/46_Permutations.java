/*

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/

// Method 1: O(n!) runtime, O(1) space

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        permuteHelper(results, list, nums);
        return results;
    }
    
    private void permuteHelper(List<List<Integer>> results,
        List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
        }
        
        for (int i = 0; i < nums.length; i++) {
            // ArrayList has the method to check if it contains
            // a specific element (like hashset)
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permuteHelper(results, list, nums);
            list.remove(list.size() - 1);
        }
    }
}

// Method 2: Use an extra array to record if the element has been chosen or not

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        permuteHelper(results, list, nums, visited);
        return results;
    }
    
    private void permuteHelper(List<List<Integer>> results,
        List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            permuteHelper(results, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
