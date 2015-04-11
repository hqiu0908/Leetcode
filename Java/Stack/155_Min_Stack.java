/*

Design a stack that supports push, pop, top, and retrieving the minimum element
in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

*/

class MinStack {
    private Stack<Integer> origStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();  
    
    public void push(int x) {
        origStack.push(x);
        
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            // consider the duplicated element
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (origStack.empty()) {
            return;
        }
        
        int topVal = origStack.pop();
        
        if (topVal == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return origStack.peek();
    }

    public int getMin() {
        if (minStack.empty()) {
            return Integer.MIN_VALUE;
        }
            
        return minStack.peek();
    }
}

