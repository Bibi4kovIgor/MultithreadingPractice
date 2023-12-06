package edu.lemon.runnable;

import java.util.concurrent.TimeUnit;

public class ThreadCreate {

    public static void main(String[] args) {

    Thread thread1 = new Thread(() ->{
        for (int i = 0; i < 1000; i++) {
            System.out.println("thread1 " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    Thread thread2 = new Thread(() ->{
        for (int i = 0; i < 1000; i++) {
            System.out.println("thread2 " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    RunnableThread runnableThread1 = new RunnableThread("runnableThread1", 1, 1000, 1 );
    RunnableThread runnableThread2 = new RunnableThread("runnableThread2", 10, 800, 2 );
    RunnableThread runnableThread3 = new RunnableThread("runnableThread3", 100, 1000, 3 );

    thread1.start();
    thread2.start();
    runnableThread1.run();
    runnableThread2.run();
    runnableThread3.run();

    }
}
