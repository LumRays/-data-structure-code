public class HashBucket {

    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;
    public static final double LOAD_FACTOR = 0.75;

    public HashBucket() {
        array = new Node[10];
    }

    public void push(int key,int val) {
        int index = key % array.length;
        //看一下 22 是不是在当前数组下标存储过 如果有 要更新 val 值
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //进行插入了
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if (calcLoadFactor() >= LOAD_FACTOR) {
            //扩容
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        //重新哈希 遍历数组的每个链表
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int newIndex = cur.key % newArray.length;
                //开始头插法
                Node curN = cur.next;
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curN;
            }
        }
        array = newArray;
    }

    private double calcLoadFactor() {
        return usedSize * 1.0 / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return - 1;
    }

}
