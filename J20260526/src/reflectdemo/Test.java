package reflectdemo;

import reflectdemo.Student;

public class Test {

    public static void main(String[] args) {
        Class<?> c1;
        try {
            c1 = Class.forName("reflectdemo.Student");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Class<?> c2 = Student.class;

        Student student = new Student();
        Class<?> c3 = student.getClass();

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);
    }

}
