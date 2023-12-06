package edu.lemon.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class SerialNumberGenerator {
    private static final AtomicInteger nextSerialNumber = new AtomicInteger();

    public static int generateSerialNumber() {
        return nextSerialNumber.getAndIncrement(); // nextSerialNumber = nextSerialNumber + 1
    }

    public static int getSerialNumber() {
        return nextSerialNumber.get();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->
        {
            for (int i = 0; i < 1000; i++) {
                System.out.println(getSerialNumber());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(generateSerialNumber());
            }
        });

        thread1.start();
        thread2.start();
    }


}
