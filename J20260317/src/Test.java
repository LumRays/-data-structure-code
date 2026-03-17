
class Person {

}

class Student extends Person {

}

class MyArray<E extends Person> {

}

public class Test {
    public static void main(String[] args) {
        MyArray<Student> myArray = new MyArray<>();
        MyArray<Person> myArray2 = new MyArray<>();
        //MyArray<Integer> myArray3 = new MyArray<>();
    }
}
