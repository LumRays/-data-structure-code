package enumdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) {
        Class<?> c1;
        try {
            c1 = Class.forName("enumdemo.TestEnum");
            Constructor<?> constructor = c1.getDeclaredConstructor(String.class,int.class,int.class,String.class);
            constructor.setAccessible(true);
            TestEnum testEnum = (TestEnum)constructor.newInstance("success",5,6,"蓝色");
            System.out.println(testEnum);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
