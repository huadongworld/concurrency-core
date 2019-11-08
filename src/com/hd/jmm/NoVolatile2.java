package com.hd.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile不适用的情况2
 *
 * @author HuaDong
 * @date 2019/11/8 10:56
 */
public class NoVolatile2 implements Runnable {

    private volatile boolean done = false;
    private AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r =  new NoVolatile2();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((NoVolatile2) r).done);
        System.out.println(((NoVolatile2) r).realA.get());
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            flipDone();
            realA.incrementAndGet();
        }
    }

    private void flipDone() {
        done = !done;
    }
}
