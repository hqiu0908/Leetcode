/*

Given a set of candidate numbers (C) and a target number (T), find all unique
combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note: All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie,
a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,  

A solution set is:  
[7]
[2, 2, 3]

*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(results, list, candidates, target, 0);
        return results;
    }
    
    private void combinationSumHelper(List<List<Integer>> results,
        List<Integer> list, int[] candidates, int target, int start) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        // Maintain a start position here to make sure that the combination is
        // in a non-descending order (also prevent duplicates).
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumHelper(results, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
