package thread;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(1,3).mapToObj(ThreadJoin::creat).collect(toList());

        threads.forEach(Thread::start);

        for(Thread thread : threads)
        {
            thread.join();
        }
        for(int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName()+"#"+i);
            shortSleep();
        }
    }
    public static Thread creat(int seq){
        return new Thread(()->
        {
            for(int i = 0; i < 10; i++)
            {
                System.out.println(Thread.currentThread().getName()+"#"+i);
                shortSleep();
            }
        },String.valueOf(seq));
    }
    public static void shortSleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
