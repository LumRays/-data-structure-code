package stackdemo;

import java.util.Arrays;

public class MyStack<E> {

    public Object[] elem;
    public int usedSize;
    public static final int DEFAULT_CAPACITY = 5;

    public MyStack() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    //入栈
    public void push(E val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[usedSize] = val;
        usedSize++;
    }

    public Boolean isFull() {
        return usedSize == elem.length;
    }

    //出栈 删除栈顶元素
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E ret = (E)elem[usedSize - 1];
        usedSize--;
        return ret;
    }

    //获取栈顶元素 但是不删除
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E)elem[usedSize - 1];
    }

    public Boolean isEmpty() {
        return usedSize == 0;
    }
}
