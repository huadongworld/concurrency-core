package com.hd.thread.create;

/**
 * 用Runnable方式创建线程
 *
 * @author HuaDong
 * @date 2019/10/17 10:06
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}
