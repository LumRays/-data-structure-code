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

    private static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
