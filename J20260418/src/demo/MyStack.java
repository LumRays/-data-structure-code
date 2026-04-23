package demo;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    public Queue<Integer> queue1;
    public Queue<Integer> queue2;


    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {

        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()) {
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }

    }
    
    public int pop() {

        if (empty()) {
            return -1;
        }
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            while (size - 1 != 0) {
                queue2.offer(queue1.poll());
                size--;
            }
            return queue1.poll();
        }else {
            int size = queue2.size();
            while (size - 1 != 0) {
                queue1.offer(queue2.poll());
                size--;
            }
            return queue2.poll();
        }

    }
    
    public int top() {
        if (empty()) {
            return -1;
        }
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            int val = -1;
            while (size != 0) {
                val = queue1.poll();
                queue2.offer(val);
                size--;
            }
            return val;
        }else {
            int size = queue2.size();
            int val = -1;
            while (size != 0) {
                val = queue2.poll();
                queue1.offer(val);
                size--;
            }
            return val;
        }
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
