package com.hd.thread.create;

/**
 * 用Thread方式实现线程
 *
 * @author HuaDong
 * @date 2019/10/17 10:06
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}





