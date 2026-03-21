import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>(13);
        list2.add(11);
        list2.add(21);
        list2.add(31);
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>();
    }
    public static void main3(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        try{
            myArrayList.add(0,11);
            myArrayList.add(1,21);
            myArrayList.add(2,31);
            myArrayList.add(3,41);
            myArrayList.add(4,51);
            myArrayList.display();

            myArrayList.remove(131);
            myArrayList.display();
        }catch (PosIllegalityException e) {
            e.printStackTrace();
            System.out.println("add-pos位置异常!");
        }catch (EmptyListException e) {
            e.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        try{
            myArrayList.add(0,11);
            myArrayList.add(1,21);
            myArrayList.add(2,31);
            myArrayList.add(3,41);
            myArrayList.add(4,51);
            myArrayList.display();
            myArrayList.add(5,61);
            myArrayList.add(0,99);
            myArrayList.display();
            myArrayList.set(0,18888);
            myArrayList.display();
        }catch (PosIllegalityException e) {
            e.printStackTrace();
            System.out.println("add-pos位置异常!");
        }catch (EmptyListException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.display();
        System.out.println(myArrayList.size());
        int ret = myArrayList.indexOf(4);
        System.out.println(ret);
        try {
            int i = myArrayList.get(3);
            System.out.println(i);
        }catch (EmptyListException e) {
            e.printStackTrace();
        }catch (PosIllegalityException e) {
            e.printStackTrace();
        }

    }
}
