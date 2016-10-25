/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid
but "(]" and "([)]" are not.

*/

// Method 1: Stack

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (char c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (stack.empty() || ! isValidPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
    
    public boolean isValidPair(char left, char right) {
        return (left == '(' && right == ')') 
            || (left == '{' && right == '}') 
            || (left == '[' && right == ']');
    }
}

// Method 2: Stack + HashMap

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        HashMap<Character, Character> mapping = new HashMap<Character, Character>();
        mapping.put('(', ')');
        mapping.put('{', '}');
        mapping.put('[', ']');
        
        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.empty() || mapping.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
}