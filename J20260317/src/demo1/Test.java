package demo1;

//写一个泛型类，包含一个方法，求一个T类型数组当中的最大值。数组是没有指定类型的。
class Alg<T extends Comparable<T>> {
    public T findMaxValue(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            //if (max < array[i]) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}
class Alg2 {
    public static<T extends Comparable<T>> T findMaxValue(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            //if (max < array[i]) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}
class Alg3 {
    public <T extends Comparable<T>> T findMaxValue(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            //if (max < array[i]) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}
public class Test {

    public static void main(String[] args) {
        Integer[] array = {1,21,13,41,5,16,25};
        Alg3 alg3 = new Alg3();
        int ret = alg3.findMaxValue(array);
        System.out.println(ret);
    }
    public static void main2(String[] args) {
        Integer[] array = {1,21,13,41,5,16,25};
        int ret = Alg2.<Integer>findMaxValue(array);
        System.out.println(ret);
    }
    public static void main1(String[] args) {
        Alg<Integer> alg = new Alg<>();
        Integer[] array = {1,21,13,41,5,16,25};
        int ret = alg.findMaxValue(array);
        System.out.println(ret);
    }
}
