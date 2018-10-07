class ReverseHello implements Runnable{
    int count;
    ReverseHello(int count){
        this.count = count;
    }

    public void run() {
        try{
            if(count < 10){
                Thread newThread = new Thread(new ReverseHello(count+1));
                newThread.setName("Hello From Thread "+ (count + 1));

                newThread.start();
                newThread.join();
            }
            System.out.println(Thread.currentThread().getName());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Ex4 {
    public static void main(String[] args) throws InterruptedException{
        ReverseHello reverseHello = new ReverseHello(1);
        Thread t1 = new Thread(reverseHello);
        t1.setName("Hello From Thread 1");
        t1.start();
        t1.join();
    }
}