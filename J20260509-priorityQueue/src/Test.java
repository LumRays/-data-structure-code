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

    public static void main(String[] args) {
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
