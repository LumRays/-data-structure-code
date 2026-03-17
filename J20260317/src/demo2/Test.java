package demo2;

public class Test {

    public static void func(Message<?> message) {
        System.out.println(message.getMessage());
    }
    public static void main(String[] args) {
        Message<String> stringMessage = new Message<>();
        stringMessage.setMessage("认真学习编程！");
        func(stringMessage);
        System.out.println("=============================");
        Message<Integer> integerMessage = new Message<>();
        func(integerMessage);
    }
}
