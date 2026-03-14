
class Student {

}

public class Test {

    public static void main(String[] args) {
        MyArray<String> myArray = new MyArray<String>();
        myArray.setVal(0,"abcd");
        //myArray.setVal(1,100);

        String str = myArray.getPos(0);
        System.out.println(str);
        System.out.println("================================");

        MyArray<Integer> myArray2 = new MyArray<Integer>();
        myArray2.setVal(0,100);
        myArray2.setVal(1,200);

        Integer ret = myArray2.getPos(0);
        System.out.println(ret);
        System.out.println("==================================");

        MyArray<Student> myArray3 = new MyArray<Student>();
        myArray3.setVal(0,new Student());

        Student student = myArray3.getPos(0);
    }
    public static void main3(String[] args) {
        MyArray myArray = new MyArray();
        myArray.setVal(0,"abcd");
        myArray.setVal(1,100);

        String str = (String)myArray.getPos(0);

    }
    public static void main2(String[] args) {
        Integer i = Integer.valueOf(100);

        int a = i;
        int b = i.intValue();
        System.out.println(a);
        System.out.println(b);
    }
    public static void main1(String[] args) {
        int a = 10;

        Integer i = Integer.valueOf(a);
        System.out.println(a);

        Integer ii = a;
        System.out.println(ii);
    }
}
