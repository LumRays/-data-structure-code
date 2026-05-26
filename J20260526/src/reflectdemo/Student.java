package reflectdemo;

class Student {
    //私有属性 name
    private String name = "success";
    //公有属性 age
    public int age = 18;
    //不带参数的构造方法
    public Student() {
        System.out.println("reflectdemo.Student()");
    }
    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("reflectdemo.Student(String,name)");
    }
    private void eat() {
        System.out.println("I am eating");
    }
    public void sleep() {
        System.out.println("I am lazy");
    }
    private void function(String str) {
        System.out.println(str);
    }
    @Override
    public String toString() {
        return "reflectdemo.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}