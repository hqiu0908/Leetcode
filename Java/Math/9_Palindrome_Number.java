/*

Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints: Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of
using extra space.

You could also try reversing an integer. However, if you have solved the problem
"Reverse Integer", you know that the reversed integer might overflow. How would
you handle such case?

There is a more generic way of solving this problem.

*/

public class Solution {
    public boolean isPalindrome(int x) {
        // The reverse number of x might overflow
        // So we just compare the first and last digit
        
        // Negative integers are non-palindrome
        if (x < 0) {
            return false;
        }
        
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            
            if (l != r) {
                return false;
            }
            
            x = (x % div) / 10;
            // Chop two digits at a time
            div /= 100;
        }
        
        return true;
    }
}
