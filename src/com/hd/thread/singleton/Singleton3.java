package com.hd.thread.singleton;

/**
 * 懒汉式（线程不安全）
 *
 * @author HuaDong
 * @date 2019/11/7 9:34
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
