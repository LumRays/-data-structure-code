package queuedemo;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(12);
        myQueue.offer(23);
        myQueue.offer(34);
        myQueue.offer(45);
        myQueue.offer(56);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.size());
        System.out.println(myQueue.empty());
    }

    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

}
