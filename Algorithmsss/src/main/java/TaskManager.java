import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class worker implements Runnable{
    String name;
    ReentrantLock lock;
    public worker(ReentrantLock lock, String name){
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        /**  STEPS TO LOCK/UNLOCK A RESOURCE
         * 1. check if the lock exists or not
         */
        boolean done = false;
        while(!done) {
            //since all of them are competing for the same resource, always use this while loop
            //do this mistake in interview to show that you know the difference
            //
            boolean isFree = lock.tryLock();
            if (isFree) {

                try {
                    Thread.sleep(100);
                    lock.lock();//get the inner lock
                    System.out.println("Worker " + this.name + " : lock acquired");
                    try {
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Worker " + this.name + " : " + i);
                        }
                        Thread.sleep(100);
                    } catch (Exception ex) {

                    } finally {
                        lock.unlock();

                    }
                    done = true;
                } catch (Exception ex) {

                } finally {
                    lock.unlock();
                    System.out.println("Worker " + this.name + " : lock released");
                }


            } else {
                System.out.println("Waiting for the lock " + this.name);
                try {
                    Thread.sleep(50);
                } catch (Exception ex) {

                }
            }
        }
    }
}

public class TaskManager {
    static final int MAX_THREAD_COUNT = 2;
    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock(true);

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);

        Runnable task1 = new worker(lock, "task1");
        Runnable task2 = new worker(lock, "task2");
        Runnable task3 = new worker(lock, "task3");
        Runnable task4 = new worker(lock, "task4");

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
        executorService.shutdown();

    }
}
