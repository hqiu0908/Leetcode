/*

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you
climb to the top?

*/

// Method 1: O(n) runtime, O(1) space
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int curt = 0;
        int b4prev = 1;
        int prev = 2;
        
        for (int i = 3; i <= n; i++) {
            curt = b4prev + prev;
            b4prev = prev;
            prev = curt;
        }
        
        return curt;
    }
}

// Method2: O(n) runtime, O(n) space

public class Solution {
    // f(n) = f(n - 1) + f(n - 2)
    public int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        stairs[0] = 1;
        stairs[1] = 1;
        for (int i = 2; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n];
    }
}
