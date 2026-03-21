import java.util.Arrays;

public class MyArrayList implements IList {
    //存储数据
    private int[] elem;
    //记录数组中有效的数据个数
    private int usedSize;

    public MyArrayList() {
        this.elem = new int[Constant.DEFAULT_CAPACITY];
    }
    @Override
    public void add(int data) {
        //1.判断顺序表是否满了
        if (isFull()) {
            //2.如果满了，则要进行扩容操作
            grow();
        }
        //3.存储数据
        this.elem[usedSize] = data;
        //4.记录usedSize
        this.usedSize++;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    private void grow() {
        this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
    }

    @Override
    public void add(int pos, int data) {
        //是否是满的
        if (isFull()) {
            grow();
        }
        String msg = Constant.ADD_POS_ILLEGALITY + pos;
        checkPosAdd(pos,msg);
        //1.判断是否放在usedSize的位置
        if (pos == usedSize) {
            elem[pos] = data;
            usedSize++;
            return;
        }
        //2.移动数据
        for (int i = usedSize - 1; i >= pos ; i--) {
            elem[i + 1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }

    private void checkPosAdd(int pos,String msg) {
        if (pos < 0 || pos > usedSize) {
            throw new PosIllegalityException(msg);
        }
    }

    @Override
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) {
        if (isEmpty()) {
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        String msg = Constant.GET_POS_ILLEGALITY + pos;
        checkPos(pos,msg);
        return elem[pos];
    }

    private void checkPos(int pos,String msg) {
        if (pos < 0 || pos >= usedSize) {
            throw new PosIllegalityException(msg);
        }
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    @Override
    public void set(int pos, int value) {
        if (isEmpty()) {
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        String msg = Constant.SET_POS_ILLEGALITY + pos;
        checkPos(pos,msg);
        elem[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        if (isEmpty()) {
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        //2.查找要删除数据的下标
        int index = indexOf(toRemove);
        if (index == -1){
            System.out.println("没有你要删除的数据！");
            return;
        }
        for (int i = index; i < usedSize - 1; i++) {
            elem[i] = elem[i + 1];
        }
        usedSize--;
        //如果是引用类型 需要手动置为空
        //elem[usedSize] = null;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void clear() {
        for (int i = 0; i < usedSize; i++) {
            //elem[i] = null;
            elem[i] = 0;
        }

        usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
