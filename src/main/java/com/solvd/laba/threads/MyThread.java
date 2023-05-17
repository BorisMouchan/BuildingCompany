package com.solvd.laba.threads;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread - START " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread - END " + Thread.currentThread().getName());
    }

    public static void doConnection() throws InterruptedException {
        Thread.sleep(1000);
    }
}
