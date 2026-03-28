public interface ILinkedList {
        //头插法
        void addFirst(int data);
        //尾插法
        void addLast(int data);
        //任意位置插⼊,第⼀个数据节点为0号下标
        void addIndex(int index,int data);
        //查找是否包含关键字key是否在单链表当中
        boolean contains(int key);
        //删除第⼀次出现关键字为key的节点
        void remove(int key);
        //删除所有值为key的节点
        void removeAllKey(int key);
        //得到单链表的⻓度
        int size();
        void clear();
        void display();
}
