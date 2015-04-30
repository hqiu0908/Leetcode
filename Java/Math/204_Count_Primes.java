/*

Description:

Count the number of prime numbers less than a non-negative number, n

click to show more hints.

References:
How Many Primes Are There?

Sieve of Eratosthenes

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

*/

public class Solution {
    // If we try to divide the prime by other numbers, it would cause
	// the error 'time limit exceeded' for a large prime number
    public int countPrimes(int n) {
    	if (n <= 2) {
    		return 0;
    	}
    	
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        
        for (int i = 2; i <= (int)Math.sqrt(n - 1); i++) {
            for (int j = i * i; j < n; j += i) {
            	if (!notPrime[j]) {
            		notPrime[j] = true;
            	}
            }
        }
        
        int num = 0;
        for (int i = 0; i < n; i++) {
        	if (!notPrime[i]) {
        		num++;
        	}
        }
        
        return num;
    }
}
