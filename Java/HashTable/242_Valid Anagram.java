/*

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution
to such case?

*/

// Method 1: Use hash table, time complexity: O(n)
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        int[] counter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counter[(int)s.charAt(i)]++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            counter[(int)t.charAt(i)]--;
            if (counter[(int)t.charAt(i)] < 0) {
                return false;
            }
        }
        
        return true;
    }
}

// Method 2: Sort the string, time complexity: O(nlogn)

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        
        Arrays.sort(arrayS);
        Arrays.sort(arrayT);
        
        s = String.valueOf(arrayS);
        t = String.valueOf(arrayT);
        
        return s.equals(t);
    }
}
