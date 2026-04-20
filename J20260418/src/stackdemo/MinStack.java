package stackdemo;

import java.util.Stack;

public class MinStack {

    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        }else {
            int topVal = minStack.peek();
            if (val <= topVal) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        int popVal = stack.pop();
        if (popVal == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
