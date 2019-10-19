package com.hd.thread.start;

/**
 * 对比start和run两种启动线程的方式
 *
 * @author HuaDong
 * @date 2019/10/18 23:42
 */
public class StartAndRunMethod {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());

        };
        runnable.run();

        new Thread(runnable).start();
    }
}
