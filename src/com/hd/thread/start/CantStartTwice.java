package com.hd.thread.start;

/**
 * 演示不能两次调用start方法，否则会报错
 *
 * @author HuaDong
 * @date 2019/10/18 23:42
 */
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
