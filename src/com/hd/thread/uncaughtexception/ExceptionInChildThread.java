package com.hd.thread.uncaughtexception;

/**
 * 单线程，抛出，处理，有异常堆栈 多线程，子线程发生异常，会有什么不同？
 *
 * @author HuaDong
 * @date 2019/11/3 10:25
 */
public class ExceptionInChildThread implements Runnable {

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}