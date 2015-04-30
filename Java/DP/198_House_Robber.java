/*

You are a professional robber planning to rob houses along a street. Each house
has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into
on the same night.

Given a list of non-negative integers representing the amount of money of each
house, determine the maximum amount of money you can rob tonight without
alerting the police.

*/

// Method 1:

public class Solution {
    // dp[i] = max(dp[i - 1], dp[i - 2] + num[i - 1]);
    public int rob(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	   	
    	int[] curtmax = new int[nums.length + 1];
    	curtmax[1] = nums[0];

    	for (int i = 2; i <= nums.length; i++) {
    		curtmax[i] = Math.max(curtmax[i - 1], curtmax[i - 2] + nums[i - 1]);
    	}
   
        return curtmax[nums.length];
    }
}

// Method 2:

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	   	
    	int even = 0;
    	int odd = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (i % 2 == 0) {
    			even += nums[i];
    			even = Math.max(even, odd);
    		} else {
    			odd += nums[i];
    			odd = Math.max(even, odd);
    		}
    	}
    	
    	return Math.max(even, odd);
    }
}

// Method 3:

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	   	
    	int[] curtmax = new int[nums.length];
    	curtmax[0] = nums[0];
    	
    	int max = curtmax[0];
    	int prevmax = 0;
    	
    	for (int i = 1; i < nums.length; i++) {
    		curtmax[i] = nums[i] + prevmax;
    		max = Math.max(curtmax[i - 1], curtmax[i]);
    		prevmax = Math.max(prevmax, curtmax[i - 1]);
    	}
   
        return max;
    }
}