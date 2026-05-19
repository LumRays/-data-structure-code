import java.util.Deque;
import java.util.LinkedList;

public class Sort {

   /**
    *  直接插入排序
    *  时间复杂度 :
    *   最坏情况 : 逆序 O(N^2)
    *   最好情况 : 本来就是从小到大的 O(N)
    *  场景 : 如果给定了一组数据 并且告诉你 这些数据基本上是趋于有序的 [规模不大]
    *  空间复杂度 : O(1)
    *  稳定性 : 稳定的排序
    */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    // 这里改为 >= 就不是稳定的排序了
                    array[j+1] = array[j];
                }else {
                    array[j+1] = tmp;//可以直接在外面写
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    /**
    *  希尔排序
    *  时间复杂度 : O(N^1.3) ~ O(N^1.5)
    *  空间复杂度 : O(1)
    *  稳定性 : 不稳定的排序
    */
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap /= 2;
            shell(array,gap);
        }
    }

    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            // i = gap 和 i++ 交替进行插入排序
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    array[j+gap] = tmp;//可以直接在外面写
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    /**
     *  堆排序
     *  时间复杂度 : O(N*logN)
     *  空间复杂度 : O(1)
     *  稳定性 : 不稳定的排序
     */
    public static void heapSort(int[] array) {
        //1. 创建大根堆
        createHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array,0,end);
            siftDown(array,0,end);
            end--;
        }
    }

    private static void createHeap(int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(array,parent,array.length);
        }
    }

    private static void siftDown(int[] array,int parent,int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array,child,parent);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }

    /**
     *  选择排序
     *  时间复杂度 : O(N^2)
     *  空间复杂度 : O(1)
     *  稳定性 : 不稳定的排序
     */
    private static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    /**
     *  冒泡排序
     *  时间复杂度 : O(N^2)
     *             加了标记以后 最好情况下 (1,2,3,4,5) 时间复杂度为 O(N)
     *  空间复杂度 : O(1)
     *  稳定性 : 稳定的排序
     */
    public static void bubbleSort(int[] array) {
        //i 表示趟数
        for (int i = 0; i < array.length; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array,j,j+1);
                    flg = true;
                }
            }
            if (!flg) {
                return;
            }
        }
    }

    /**
     *  快速排序
     *  时间复杂度 :
     *             最坏情况下 (1,2,3,4,5) || (9,8,7,6,5) 时间复杂度为 O(N^2)
     *             最好情况下 O(N*logN) 均分待排序序列
     *  空间复杂度 :
     *             最坏情况下 O(N)
     *             最好情况下 O(logN)
     *  稳定性 : 不稳定的排序
     */
    public static void quickSort(int[] array) {
        quick(array,0, array.length - 1);
    }

    private static void quick(int[] array,int start,int end) {
        if (start >= end) {
            return;
        }
        if (end - start + 1 <= 10) {
            //直接插入排序
            insertSortRange(array,start,end);
            return;
        }
        //进行三数取中 找到下标
        int index = threeMid(array,start,end);
        swap(array,start,index);
        int par = parttion(array,start,end);
        quick(array,start,par - 1);
        quick(array,par + 1,end);
    }

    private static void insertSortRange(int[] array,int low,int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= low; j--) {
                if (array[j] > tmp) {
                    // 这里改为 >= 就不是稳定的排序了
                    array[j+1] = array[j];
                }else {
                    array[j+1] = tmp;//可以直接在外面写
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //Hoare法
    private static int parttionHoare(int[] array, int low, int high) {
        int pivot = array[low];
        //记录原来 low 下标
        int i = low;
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            while (low < high && array[low] <= pivot) {
                low++;
            }
            swap(array, low, high);
        }
        swap(array,i,low);
        return low;
    }

    //三数取中法
    private static int threeMid(int[] array,int low,int high) {
        int mid = (low + high) / 2;
        if (array[low] < array[high]) {
            if (array[mid] < array[low]) {
                return low;
            } else if (array[mid] > array[high]) {
                return high;
            }else {
                return mid;
            }
        }else {
            //array[low] > array[high]
            if (array[mid] < array[high]) {
                return high;
            } else if (array[mid] > array[low]) {
                return low;
            }else {
                return mid;
            }
        }
    }

    //挖坑法
    private static int parttion2(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            // = 是不可以省略的 否则会死循环
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            // = 是不可以省略的 否则会死循环
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    //前后指针法
    private static int parttion(int[] array, int low, int high) {
        int prev = low;
        int cur = low + 1;
        while (cur <= high) {
            if(array[cur] < array[low] && array[++prev] != array[cur]) {
                swap(array,cur,prev);
            }
            cur++;
        }
        swap(array,prev,low);
        return prev;
    }

    //快速排序非递归
    public static void quickSortNor(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int par = parttion2(array,start,end);
        Deque<Integer> stack = new LinkedList<>();
        //左边有两个数对
        if (par > start + 1) {
            stack.push(start);
            stack.push(par - 1);
        }
        //右边有两个数对
        if (par < end - 1) {
            stack.push(par + 1);
            stack.push(end);
        }
        //栈是否为空 直到栈为空 则结束 每次从栈里拿出 2 个元素
        while (!stack.isEmpty()) {
            end = stack.pop();
            start = stack.pop();
            par = parttion2(array,start,end);
            //左边有两个数对
            if (par > start + 1) {
                stack.push(start);
                stack.push(par - 1);
            }
            //右边有两个数对
            if (par < end - 1) {
                stack.push(par + 1);
                stack.push(end);
            }
        }

    }

    /**
     *  归并排序
     *  时间复杂度 : O(N*logN)
     *  空间复杂度 : O(N)
     *  稳定性 : 稳定的排序
     */
    public static void mergeSort(int[] array) {
        mergeSortChild(array,0, array.length - 1);
    }

    private static void mergeSortChild(int[] array,int left,int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortChild(array,left,mid);
        mergeSortChild(array,mid + 1,right);
        //合并
        merge(array,left,mid,right);
    }

    private static void merge(int[] array,int left,int mid,int right) {
        int[] tmp = new int[right - left + 1];
        int k = 0;
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        //保证两个子序列当中 都有数据
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                tmp[k++] = array[s1++];
            }else {
                tmp[k++] = array[s2++];
                //k++;
                //s2++;
            }
        }
        while (s1 <= e1) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmp[k++] = array[s2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            array[i + left] = tmp[i];
        }
    }

    //归并排序非递归
    public static void mergeSortNon(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i = i + 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                int right = mid + gap;
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array,left,mid,right);
            }
            gap *= 2;
        }
    }

    /**
     *  计数排序
     *  时间复杂度 : O(max(N,范围))
     *  空间复杂度 : O(范围)
     *  稳定性 : 稳定的排序
     */
    public static void countSort(int[] array) {
        //1. 找到数组的最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        //2. 定义一个计数数组
        int range = max - min + 1;
        int[] count = new int[range];
        //3. 遍历 array 数组 开始计数
        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            count[index - min]++;
        }
        //4. 遍历计数数组
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[k++] = i + min;
                count[i]--;
                //k++;
            }
        }
    }

}
