package com.solvd.laba.threads;

public class ThreadMRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            doConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing processing with Runnable - END " + Thread.currentThread().getName());
    }

    public static void doConnection() throws InterruptedException {
        Thread.sleep(5000);
    }
}
