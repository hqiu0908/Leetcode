/*

Given a non-negative number represented as an array of digits, plus one to the
number.

The digits are stored such that the most significant digit is at the head of the
list.

*/

// Method 1:

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return new int[]{-1};
        }
        
        int carry = 1;
        
        for (int i = digits.length - 1; i>= 0 && carry > 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry == 0) {
            return digits;
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < digits.length + 1; i++) {
            result[i] = digits[i - 1];
        }
        
        return result;
    }
}

// Method 2:

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return new int[]{-1};
        }
        
        for (int i = digits.length - 1; i>= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < digits.length + 1; i++) {
            result[i] = digits[i - 1];
        }
        
        return result;
    }
}

// Use ArrayList:

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class PlusOne {
    
    public List<Integer> plusOne(List<Integer> digits) {        
        if (digits == null) {
            return null;
        }
        
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits.get(i) < 9) {
                digits.set(i, digits.get(i) + 1);
                return digits;
            } else {
                digits.set(i, 0);
            }
        }
        
        digits.add(0, 1);
        return digits;
    }
    
    public static void main (String[] args) {
        PlusOne plusOne = new PlusOne();
        
        List<Integer> digits = new ArrayList<Integer>();
        Collections.addAll(digits, 9, 9, 9);
        
        List<Integer> results = new ArrayList<Integer>();       
        results = plusOne.plusOne(digits);
        
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i) + " ");
        }
    }
}

