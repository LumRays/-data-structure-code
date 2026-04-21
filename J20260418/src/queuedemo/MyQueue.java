package queuedemo;

public class MyQueue {

    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode first;
    public ListNode last;

    //入队操作   尾插法
    public void offer(int val) {
        ListNode node = new ListNode(val);
        if (first == null) {
            first = last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    //获取队头元素删除
    public int poll() {
        if (first == null) {
            return -1;
        }
        int val = first.val;
        if (first == last) {
            first = null;
            last = null;
        }else {
            first = first.next;
            first.prev = null;
        }
        return val;
    }

    //获取队头元素但是不删除
    public int peek() {
        if (first == null) {
            return -1;
        }
        int val = first.val;
        return val;
    }

    //相当于求链表的长度
    public int size() {
        ListNode cur = first;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    //判断是否为空
    public boolean empty() {
        if (first == null) {
            return true;
        }
        return false;
    }

}
