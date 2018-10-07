class MyThread extends Thread{
    int start;
    public MyThread(int start) {
        this.start = start;
    }
    public void run() {
        while(start <= 10){
            System.out.println(Thread.currentThread().getName() +" "+start);
            start += 4;
        }
    }
}
public class Ex9 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            MyThread myThread = new MyThread(i+1);
            myThread.setName("Thread--"+(i+1));
            myThread.start();
        }
        Thread.sleep(500l);
    }
}