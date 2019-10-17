package com.hd.thread.create.wrong;

/**
 * @author HuaDong
 * @date 2019/10/17 10:15
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
