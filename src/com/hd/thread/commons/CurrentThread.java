package com.hd.thread.commons;

/**
 * 演示打印main, Thread-0, Thread-1
 *
 * @author HuaDong
 * @date 2019/11/2 17:00
 */
public class CurrentThread implements Runnable {

    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
