/*

Given a non-empty array of integers, return the third maximum number in this
array. If it does not exist, return the maximum number. The time complexity must
be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.


*/

// Method 1: Use Integer object.

// Corner case: []

public class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Integer first = null;
        Integer second = null;
        Integer third = null;
        
        for (Integer n : nums) {
            if (n.equals(first) || n.equals(second) || n.equals(third)) {
                continue;
            }
            
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }
        
        return (third == null)? first : third;
    }
}

// Method 2: Use long as the initial min value.

public class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n < max1 && n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n < max2 && n > max3) {
                max3 = n;
            }
        }
        
        return (int)((max3 == Long.MIN_VALUE)? max1 : max3);
    }
}

// Java TreeSet, ordered, time complexity O(logn).
// Time complexity: http://infotechgems.blogspot.com/2011/11/java-collections-performance-time.html