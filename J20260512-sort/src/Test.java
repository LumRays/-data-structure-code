import java.util.Arrays;
import java.util.Random;

public class Test {

    //从小到大
    public static void order(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    //从大到小
    public static void inorder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
    }

    public static void randomOrder(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10_0000);
        }
    }


    public static void testInsertSort(int[] array) {
        int[] array2 = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(array2);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序耗时: " + (endTime - startTime));
    }

    public static void testShellSort(int[] array) {
        int[] array2 = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(array2);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时: " + (endTime - startTime));
    }

    public static void testHeapSort(int[] array) {
        int[] array2 = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.heapSort(array2);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时: " + (endTime - startTime));
    }

    public static void testSelectSort(int[] array) {
        int[] array2 = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(array2);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时: " + (endTime - startTime));
    }

    public static void testBubbleSort(int[] array) {
        int[] array2 = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.bubbleSort(array2);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        int[] array = new int[10_0000];
        //order(array);
        inorder(array);
        //randomOrder(array);
        testInsertSort(array);
        testShellSort(array);
        testHeapSort(array);
        testSelectSort(array);
        testBubbleSort(array);
    }

    public static void main1(String[] args) {
        int[] array = {31,12,13,141,54,66,27,18};
        //Sort.insertSort(array);
        //Sort.shellSort(array);
        //Sort.heapSort(array);
        //Sort.selectSort(array);
        Sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
