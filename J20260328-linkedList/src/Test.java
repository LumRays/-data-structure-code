public class Test {
    public static void main(String[] args) {
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
