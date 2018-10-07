import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Increment implements Runnable{
    Counter c;
    public Increment(Counter counter)
    {
        this.c = counter;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            c.inc();
        }
    }
}
class Counter{
    static int count = 0;
    public synchronized void inc() {
        count++;
    }
    public int getCount() {
        return this.count;
    }
}
public class Ex10 {
    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        Counter c = new Counter();
        for (int i = 0; i < 5; i++) {
            Increment increment = new Increment(c);
            executor.submit(increment);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println(c.getCount());
    }
}