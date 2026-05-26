package reflectdemo;

public class ReflectClassDemo {

    public static void reflectNewInstance() {
        Class<?> aClass;
        try {
            aClass = Class.forName("reflectdemo.Student");
            Student student = (Student)aClass.newInstance();
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        reflectNewInstance();
    }

}
