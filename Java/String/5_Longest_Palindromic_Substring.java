/*

Given a string S, find the longest palindromic substring in S. You may assume
that the maximum length of S is 1000, and there exists one unique longest
palindromic substring.

*/

// Method 1: Dynamic Programming

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        
        // Use DP. O(n^2) time, O(n^2) space
        // isPalindrome[i][j]: if s.substring(i, j + 1) is palindrome
        boolean[][] isPalindrome = new boolean[1000][1000];
        int maxLen = 1;
        int longestStart = 0;
        
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                longestStart = i;
                maxLen = 2;
            }
        }
        
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    longestStart = i;
                    maxLen = len;
                }
            }
        }
        
        return s.substring(longestStart, longestStart + maxLen);
    }
}

// Method 2: Expand from center

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        
        // O(n ^ 2) runtime, O(1) space
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}

// Method 2: Expand from center

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}


