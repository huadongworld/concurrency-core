package com.hd.thread.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile适用的情况1
 *
 * @author HuaDong
 * @date 2019/11/8 10:53
 */
public class UseVolatile1 implements Runnable {

    private volatile boolean done = false;
    private AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r =  new UseVolatile1();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((UseVolatile1) r).done);
        System.out.println(((UseVolatile1) r).realA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            setDone();
            realA.incrementAndGet();
        }
    }

    private void setDone() {
        done = true;
    }
}
