package com.hd.singleton;

/**
 * 静态内部类方式，可用
 *
 * @author HuaDong
 * @date 2019/11/7 9:35
 */
public class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {

        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
