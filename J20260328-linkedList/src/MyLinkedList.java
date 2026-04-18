public class MyLinkedList implements ILinkedList {

    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;

    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        //1. 检查index的合法性
        checkPos(index);
        //2. 特殊位置的插入
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }

        //3. 中间位置的插入
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    private ListNode searchIndex(int index) {
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    private void checkPos(int index) {
        if (index < 0 || index > size()) {
            throw new CheckPosException("index 位置不合法: " + index);
        }
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = head;
        while(cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                //开始删除
                if (cur == head) {
                    //删除的节点是头节点
                    head = head.next;
                    if (head != null) {
                        //防止当前双向链表只有一个节点
                        head.prev = null;
                    }
                }else {
                    //删除的节点不是头节点
                    if(cur.next == null) {
                        //删除尾巴节点
                        last = last.prev;
                    }else {
                        //删除中间节点
                        cur.next.prev = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
                return;
            }
            cur = cur.next;
        }
    }

    @Override
    public void removeAllKey(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                //开始删除
                if (cur == head) {
                    //删除的节点是头节点
                    head = head.next;
                    if (head != null) {
                        //防止当前双向链表只有一个节点
                        head.prev = null;
                    }
                }else {
                    //删除的节点不是头节点
                    if(cur.next == null) {
                        //删除尾巴节点
                        last = last.prev;
                    }else {
                        //删除中间节点
                        cur.next.prev = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
            }
            cur = cur.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void clear() {
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        last = null;
    }

    @Override
    public void display() {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
