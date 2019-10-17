package com.hd.thread.create;

/**
 * 同时使用Runnable和Thread两种实现线程的方式
 *
 * @author HuaDong
 * @date 2019/10/17 10:03
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(
                () -> System.out.println("我来自Runnable")
        ) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
