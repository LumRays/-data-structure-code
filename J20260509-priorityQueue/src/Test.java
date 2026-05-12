import java.util.Comparator;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {

    public int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}

class Imp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

public class Test {


    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }
        //1. 创建大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //2. 遍历数组的前 K 个元素 将其放到大根堆当中
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);

        }
        //3. 遍历剩下的 N - K 个元素 每个元素和堆顶元素进行比较
        //   若小于堆顶元素 那么就删除堆顶元素
        for (int i = k; i < arr.length; i++) {
            int peekVal = maxHeap.peek();
            if (peekVal > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        //4. 把元素放到数组里面
        for (int i = 0; i < k; i++) {
            int val = maxHeap.poll();
            ret[i] = val;
        }
        return ret;
    }

    public int[] smallestK1(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //1. 把数组当中的所有元素 全部放到小根堆当中 O(N * logN)
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }
        //2. 从堆里面删除 K 个元素放到 ret 当中
        for (int i = 0; i < k; i++) {
            int val = minHeap.poll();
            ret[i] = val;
        }
        return ret;
    }

    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.init(array);
        testHeap.createHeap();
        testHeap.heapSort();
    }


    public static void main3(String[] args) {
        Imp imp = new Imp();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(imp);
        priorityQueue.offer(10);
        priorityQueue.offer(3);
        System.out.println(priorityQueue.peek());
        System.out.println("================");

        //改为大根堆
        PriorityQueue<Student> priorityQueue2 = new PriorityQueue<>();
        priorityQueue2.offer(new Student(10));
        priorityQueue2.offer(new Student(3));
        System.out.println(priorityQueue2.peek());
    }

    public static void main2(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(9);
        System.out.println(priorityQueue.peek());//1
    }

    public static void main1(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.init(array);
        testHeap.createHeap();
        //testHeap.offer(70);
        System.out.println(testHeap.poll());
    }

}
