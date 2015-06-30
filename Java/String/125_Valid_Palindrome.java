/*

Given a string, determine if it is a palindrome, considering only alphanumeric
characters and ignoring cases.

For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is
not a palindrome.

Note: Have you consider that the string might be empty? This is a good question
to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            while ( !isAlphaNumeric(s.charAt(i)) && (i < j) ) {
                i++;
            }
            
            while ( !isAlphaNumeric(s.charAt(j)) && (i < j) ) {
                j--;
            }
            
            if ( Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)) ) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean isAlphaNumeric(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
            || (c >= '0' && c <= '9'));
    }
}
