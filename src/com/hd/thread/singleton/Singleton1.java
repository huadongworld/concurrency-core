package com.hd.thread.singleton;

/**
 * 饿汉式（静态常量）（可用）
 *
 * @author HuaDong
 * @date 2019/11/7 9:34
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
