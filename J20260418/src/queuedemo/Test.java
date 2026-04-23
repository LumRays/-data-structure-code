package queuedemo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();

    }


    public static void main3(String[] args) {

        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());

    }

    public static void main2(String[] args) {
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
