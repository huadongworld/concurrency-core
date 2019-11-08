package com.hd.thread.singleton;

/**
 * 饿汉式（静态代码块）（可用）
 *
 * @author HuaDong
 * @date 2019/11/7 9:34
 */
public class Singleton2 {

    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
