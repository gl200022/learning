package thread;

public class Demo {
    public static void main(String[] args) {
        Msg msg = () -> System.out.println("hello world");
        msg.print();
    }
}
