package edu.lemon.runnable;

import java.util.concurrent.TimeUnit;

public class RunnableThread implements Runnable {


    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    private final String name;
    private final int startValue;
    private final int finishValue;
    private final int sleepTimeSeconds;

    public RunnableThread(String name, int startValue, int finishValue, int sleepTimeSeconds) {
        this.name = name;
        this.startValue = startValue;
        this.finishValue = finishValue;
        this.sleepTimeSeconds = sleepTimeSeconds;
    }

    @Override
    public void run() {
        for (int i = startValue; i <= finishValue; i++) {
            System.out.println(name + " " + i);
            try {
                TimeUnit.SECONDS.sleep(sleepTimeSeconds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
