package thread;

public class Task implements Runnable{
    //加上static就是同步的了
    private final Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(new Task(),String.valueOf(i)).start();
        }
    }
}
