import java.util.Arrays;

public class TestHeap {

    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void init(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    //创建大根堆(采用的是向下调整的方式)
    //时间复杂度 O(n)
    public void createHeap() {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(parent,usedSize);
        }
    }

    //向下调整 -> 大根堆
    private void siftDown(int parent, int usedSize) {
        //1. 先得到孩子节点的下标child 左孩子
        int child = 2 * parent + 1;
        while (child < usedSize) {
            //2. 左右孩子进行大小比较 记录下来 child表示最大值
            if (child + 1 < usedSize && elem[child] < elem[child + 1]) {
                child++;
            }
            //3. 让左右孩子最大值和根节点进行比较 如果大于根节点则进行交换
            if (elem[child] > elem[parent]) {
                swap(elem,child,parent);
                parent = child;
                child = 2 * parent + 1;
            }else {
                //   如果不大于根节点 就直接调整结束了
                break;
            }
        }
    }

    private void swap(int[] elem,int i,int j) {
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }

    public void offer(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[usedSize] = val;
        //调整
        siftUp(usedSize);
        usedSize++;
    }

    private void siftUp(int child) {
        //1. 求 parent
        int parent = (child - 1) / 2;
        //2. 开始持续调整
        while (parent >= 0) {
            //3. child 和 parent 进行比较
            if (elem[child] > elem[parent]) {
                swap(elem,child,parent);
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int ret = elem[0];
        swap(elem,0, usedSize - 1);
        usedSize--;
        siftDown(0,usedSize);
        return ret;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return elem[0];
    }

    public void heapSort() {
        int end = usedSize - 1;
        while (end > 0) {
            swap(elem,0,end);
            siftDown(0,end);
            end--;
        }
    }

}
