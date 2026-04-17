public class Test {

    public MySingleList.ListNode getIntersectionNode(MySingleList.ListNode headA, MySingleList.ListNode headB) {
        MySingleList.ListNode pl = headA;
        MySingleList.ListNode ps = headB;
        //这里保存headA的这个链表的长度
        int lenA = 0;
        //这里保存headB的这个链表的长度
        int lenB = 0;
        //分别求长度
        while(pl != null) {
            lenA++;
            pl = pl.next;
        }
        while(ps != null) {
            lenB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        //计算差值
        int len = lenA - lenB;
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        //pl一定指向最长的链表  ps一定指向最短的链表  len一定是正数
        while(len != 0) {
            pl = pl.next;
            len--;
        }
        while(pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }


    public static MySingleList.ListNode mergeTwoLists(MySingleList.ListNode head1, MySingleList.ListNode head2) {
        MySingleList.ListNode newHead = new MySingleList.ListNode(-1);
        MySingleList.ListNode tmp = newHead;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tmp.next = head1;
                tmp = head1;
                head1 = head1.next;
            }else {
                tmp.next = head2;
                tmp = head2;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            tmp.next = head1;
        }
        if(head2 != null) {
            tmp.next = head2;
        }
        return newHead.next;
    }

    public static void createCut(MySingleList.ListNode headA, MySingleList.ListNode headB) {
        
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(12);
        mySingleList.addLast(23);
        mySingleList.addLast(34);
        mySingleList.addLast(45);
        mySingleList.addLast(56);
        mySingleList.display();

        System.out.println("======================");

        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(10);
        mySingleList2.addLast(28);
        mySingleList2.addLast(48);
        mySingleList2.addLast(70);
        mySingleList2.addLast(86);
        mySingleList2.display();

        System.out.println("======================");
    }

    public static void main3(String[] args) {
        MySingleList mySingleList = new MySingleList();

        mySingleList.addLast(11);
        mySingleList.addLast(21);
        mySingleList.addLast(21);
        mySingleList.addLast(11);
        mySingleList.display();

        System.out.println("==============");

        boolean flg = mySingleList.chkPalindrome();
        System.out.println(flg);
    }

    public static void main2(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(12);
        mySingleList.addLast(23);
        mySingleList.addLast(34);
        mySingleList.addLast(45);
        mySingleList.addLast(56);
        mySingleList.display();

        System.out.println("======================");

        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(10);
        mySingleList2.addLast(28);
        mySingleList2.addLast(48);
        mySingleList2.addLast(70);
        mySingleList2.addLast(86);
        mySingleList2.display();

        MySingleList.ListNode newHead = mergeTwoLists(mySingleList.head,mySingleList2.head);
        mySingleList.display(newHead);
        /*int ret = mySingleList.kthToLast(1);
        System.out.println(ret);*/

        /*MySingleList.ListNode ret = mySingleList.middleNode();
        System.out.println(ret.val);*/

        /*mySingleList.reverseList();
        mySingleList.display();*/
    }
    public static void main1(String[] args) {
        MySingleList mySingleList = new MySingleList();
        //mySingleList.createList();
        mySingleList.addFirst(12);
        mySingleList.addFirst(23);
        mySingleList.addFirst(34);

        System.out.print("头插法: ");
        mySingleList.display();

        mySingleList.addLast(34);
        System.out.print("尾插法: ");
        mySingleList.display();

        mySingleList.addIndex(0,34);
        mySingleList.addIndex(3,34);
        System.out.print("任意位置插入: ");
        mySingleList.display();

        mySingleList.remove(34);

        System.out.print("删除第一次出现 key 的节点: ");
        mySingleList.display();

        mySingleList.removeAllKey(34);
        System.out.print("删除所有值为 key 的节点: ");
        mySingleList.display();

        mySingleList.clear();
        System.out.println("清空: ");
        mySingleList.display();

        /*System.out.print("有效的长度: ");
        System.out.println(mySingleList.size());

        System.out.println(mySingleList.contains(245));*/

        /*System.out.println("头插法: ");
        mySingleList.addFirst(99);
        mySingleList.display();*/

    }
}
