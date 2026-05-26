package lambdademo;

import java.util.Comparator;
import java.util.PriorityQueue;

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    //注意：只能有一个抽象方法
    void test();
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}

//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}



//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class Test {

    public static void main(String[] args) {
        //NoParameterReturn noParameterReturn = () -> {return 10;};
        NoParameterReturn noParameterReturn = () -> 10;
        System.out.println(noParameterReturn.test());
        MoreParameterReturn moreParameterReturn = (a,b) -> a + b;
        System.out.println(moreParameterReturn.test(6, 2));
    }

    public static void main1(String[] args) {
        NoParameterNoReturn noParameterNoReturn = new NoParameterNoReturn() {
            @Override
            public void test() {
                System.out.println("hello");
            }
        };
        noParameterNoReturn.test();
        NoParameterNoReturn noParameterNoReturn2 = () -> {System.out.println("hello");};
        noParameterNoReturn2.test();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((x,y) -> {return x.compareTo(y);});

    }

}
