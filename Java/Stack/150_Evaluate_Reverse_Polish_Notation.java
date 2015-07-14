/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

*/

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String s : tokens) {
            String operator = "+-*/";
            
            if (!operator.contains(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                
                switch (s) {
                    case "+": stack.push(b + a);
                              break;
                    case "-": stack.push(b - a);
                              break;
                    case "*": stack.push(b * a);
                              break;
                    case "/": stack.push(b / a);
                              break;                              
                }
            }
        }
        
        return stack.pop();
    }
}
