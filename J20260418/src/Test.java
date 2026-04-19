import java.util.*;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //压栈
        stack.push(12);
        stack.push(23);
        stack.push(34);
        stack.push(45);

        int ret = stack.pop();
        System.out.println(ret);

        //peek 获取栈顶元素
        int ret2 = stack.peek();
        System.out.println(ret2);
    }


    public static void main2(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(18);
        list.add(45);
        list.add(98);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("===================");

        for (Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("===================");

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("===================");

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        System.out.println("===================");

        ListIterator<Integer> listIterator2 = list.listIterator(list.size());
        while (listIterator2.hasPrevious()) {
            System.out.print(listIterator2.previous() + " ");
        }
        System.out.println();
        System.out.println("===================");
    }

    public static void main1(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(1,100);
        System.out.println(list);

        List<Integer> list2 = new LinkedList<>();

        List<Integer> list3 = new ArrayList<>();
        list3.add(9);
        list3.add(99);

        list.addAll(list3);

        System.out.println(list);

        list.clear();
    }
}
