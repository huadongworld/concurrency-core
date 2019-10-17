package com.hd.thread.create.wrong;

/**
 * lambda表达式创建线程
 *
 * @author HuaDong
 * @date 2019/10/17 10:11
 */
public class Lambda {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}







