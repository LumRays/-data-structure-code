import java.util.List;

public class MySingleList implements ILinkedList {
    //定义静态内部类 来表示 节点对象
    static class ListNode{
        //数据
        public int val;
        //节点的引用
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    //存储链表的头节点的引用
    public ListNode head;

    public void createList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = node1;
    }

    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        //如果链表当中一个元素都没有，此时 插入的节点 就是第一个节点
        if (head == null) {
            head = node;
            return;
        }
        //1. 找到链表的尾巴
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        //cur 指向的节点 就是尾巴节点
        cur.next = node;
    }

    @Override
    public void addIndex(int index, int data) {
        checkPos(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }

        //中间位置的插入
        ListNode cur = findIndex(index);

        ListNode node = new ListNode(data);

        node.next = cur.next;
        cur.next = node;

    }

    private ListNode findIndex(int index) {
        ListNode cur = head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
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
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (head == null) {
            System.out.println("链表为空,删除错误！");
            return;
        }
        //1. 要删除的节点 是头节点
        if (head.val == key) {
            head = head.next;
            return;
        }
        //2. 删除的节点是其他节点
        ListNode cur = search(key);
        if (cur == null) {
            System.out.println("没有你要删除的数字: " + key);
            return;
        }
        ListNode del = cur.next;

        cur.next = del.next;

    }


    //找到 key 的前驱
    private ListNode search(int key) {
        ListNode cur = head;
        while(cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {

        if (head == null) {
            return;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        //最后判断一次头节点
        if (head.val == key) {
            head = head.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void clear() {
        ListNode cur = head;
        while (cur != null) {
            cur.val = 0;
            ListNode curNow = cur.next;
            cur.next = null;
            cur = curNow;
        }
        //上面的不写也行,直接把头节点置为 null 就行
        head = null;
    }

    @Override
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
