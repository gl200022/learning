package thread;

import java.util.concurrent.ThreadLocalRandom;

public class Ticket implements Runnable{
    private int index = 1;
    private final int MAX = 5000;

    @Override
    public void run() {
        while (index < MAX)
        {
            System.out.println(Thread.currentThread().getName()+"的号码是："+(index++));
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread window1 = new Thread(ticket, "window1");
        Thread window2 = new Thread(ticket, "window2");
        Thread window3 = new Thread(ticket, "window3");
        Thread window4 = new Thread(ticket, "window4");
        window1.start();
        window2.start();
        window3.start();
        window4.start();
    }
}
