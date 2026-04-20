package stackdemo;

import java.util.LinkedList;
import java.util.Stack;

public class Test {

    //括号匹配
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //1. 遍历字符串
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            //2. 判断是左括号放到栈里面
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else {
                //3. 说明它是右括号
                //3.1. 此时ch是右括号，但是栈是空的
                if(stack.empty()) {
                    return false;
                }
                //3.2. 此时栈不为空，所以取出栈顶元素进行判断
                //3.2.1. 匹配
                char ch2 = stack.peek();// { [ (
                if(ch2 == '(' && ch == ')' || ch2 == '{' && ch == '}' || ch2 == '[' && ch == ']') {
                    stack.pop();
                }else {
                    //3.2.2. 不匹配
                    return false;
                }
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }

    //栈的压入 弹出序列
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while(!stack.empty() && j < popV.length && stack.peek() == popV[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.empty();
    }

    private boolean isOperations(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    //逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(!isOperations(str)) {
                //是数字字符串
                stack.push(Integer.valueOf(str));
            }else {
                //是运算符
                int val2 = stack.pop();
                int val1 = stack.pop();
                switch(str) {
                    case "+" :
                        stack.push(val1 + val2);
                        break;
                    case "-" :
                        stack.push(val1 - val2);
                        break;
                    case "*" :
                        stack.push(val1 * val2);
                        break;
                    case "/" :
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);

    }

    public static void main1(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        int popVal = myStack.pop();
        System.out.println(popVal);

        int peekVal = myStack.peek();
        System.out.println(peekVal);

        peekVal = myStack.peek();
        System.out.println(peekVal);

        MyStack<String> myStack2 = new MyStack<>();

    }

}
