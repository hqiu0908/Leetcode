/*

Given a string, find the length of the longest substring without repeating
characters. For example, the longest substring without repeating letters for
"abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is
"b", with the length of 1.

*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int start = 0;
        int end = 0;
        int max = 0;
        
        HashSet<Character> hashset = new HashSet<Character>();
        
        while (end < s.length()) {
            char c = s.charAt(end);
            
            if (hashset.contains(c)) {
                // Don't need (start < end) here
                // if start equals to end, s.charAt(start) == c and will jump
                // out of the while loop
                while (s.charAt(start) != c) {
                    hashset.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                hashset.add(c);
                max = Math.max(max, end - start + 1);
            }
            
            end++;
        }
        
        return max;
    }
}
