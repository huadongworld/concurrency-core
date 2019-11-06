package com.hd.thread.commons;

/**
 * 两个线程交替打印0~100的奇偶数，用wait和notify
 *
 * @author HuaDong
 * @date 2019/11/6 16:25
 */
public class WaitNotifyPrintOddEveWait {

    private static int count = 0;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new TurningRunner(), "偶线程").start();
        new Thread(new TurningRunner(), "奇线程").start();
    }

    /**
     * 1. 拿到锁，立刻打印
     * 2. 打印完，唤醒其他线程，自己就休眠
     */
    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count < 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            //如果任务还没结束，就让出当前的锁，并休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
