package com.hd.thread.create.wrong;

/**
 * 匿名内部类的方式
 *
 * @author HuaDong
 * @date 2019/10/17 10:09
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
