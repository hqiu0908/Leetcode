/*

Reverse digits of an integer.

Example1: x = 123, return 321 Example2: x = -123, return -321

click to show spoilers.

Have you thought about this? Here are some good questions to ask before coding.
Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as
10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a
32-bit integer, then the reverse of 1000000003 overflows. How should you handle
such cases?

For the purpose of this problem, assume that your function returns 0 when the
reversed integer overflows.

*/

public class Solution {
    public int reverse(int x) {
        int res = 0;
        
        while (x != 0) {
            // Handle overflow
            // The last reversed digit is guaranteed to be 1 or 2 if x has 10 digits 
            // due to constraint of input x (integer)
            // so res == 214748364 won't overflow
            if ((res > Integer.MAX_VALUE / 10) || (res < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            
            res = res * 10 + x % 10;
            x /= 10;
        }
        
        return res;
    }
}

