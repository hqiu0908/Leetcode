/*

Given a collection of numbers that might contain duplicates, return all possible
unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        // Since we have duplicated elements here, we can't discard an element
        // if it has the same value as the element we've chosen before. So we
        // need another array here to record the status for each element.
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
            // We can't choose the current element 1) if it has been chosen
            // already 2) same value as the previous element, but the previous
            // one hasn't been chosen. Which means we should choose the elements
            // with the same value in order We can't choose the element before
            // its previous one having the same value
            if ((visited[i]) || (i != 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
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
