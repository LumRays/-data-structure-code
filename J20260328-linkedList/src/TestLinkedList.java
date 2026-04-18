public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);
        myLinkedList.display();

        myLinkedList.addLast(8);
        myLinkedList.addLast(18);
        myLinkedList.addLast(28);
        myLinkedList.addLast(38);
        myLinkedList.addLast(4);
        myLinkedList.display();

        myLinkedList.addIndex(3,88);
        myLinkedList.display();

        myLinkedList.removeAllKey(4);
        System.out.println("=======================");
        myLinkedList.display();

        System.out.println("=======================");
        int size = myLinkedList.size();
        System.out.println("节点个数: " + size);
    }
}
