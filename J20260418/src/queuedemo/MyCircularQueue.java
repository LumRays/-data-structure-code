package queuedemo;

class MyCircularQueue {

    public int[] elem;
    public int rear;
    public int front;
    public Boolean isFull = false;//标记

    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }

    //入队列
    public boolean enQueue(int value) {
        //1. 判断是否是满的
        if (isFull) {
            return false;
        }
        elem[rear] = value;
        rear = (rear + 1) % elem.length;
        if (rear == front) {
            isFull = true;
        }
        return true;
    }
    
    public boolean deQueue() {
        //1. 判断是否为空
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % elem.length;
        isFull = false;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = -1;
        if (rear == 0) {
            index = elem.length - 1;
        }else {
            index = rear - 1;
        }
        return elem[index];
    }
    
    public boolean isEmpty() {
        return !isFull && rear == front;
    }
    
    public boolean isFull() {
        return isFull;
    }
}