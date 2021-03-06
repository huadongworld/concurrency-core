package com.hd.thread.commons;

/**
 * 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
 *
 * @author HuaDong
 * @date 2019/11/6 16:00
 */
public class WaitNotifyPrintOddEvenSyn {

    private static int count;

    private static final Object lock = new Object();

    /**
     * 新建2个线程，第一个只处理偶数，第二个只处理奇数（用位运算）；用synchronized来通信
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "偶线程").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "奇线程").start();
    }
}
