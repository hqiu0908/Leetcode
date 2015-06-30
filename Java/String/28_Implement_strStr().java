/*

Returns the index of the first occurrence of needle in haystack, or -1 if needle
is not part of haystack.

*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null && needle == null) {
            return 0;
        }
        
        if (haystack == null || needle == null) {
            return -1;
        }
        
        if (needle.length() == 0) {
            return 0;
        }
        
        if (haystack.length() == 0) {
            return -1;
        }
        
        int i, j;
        for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
}

