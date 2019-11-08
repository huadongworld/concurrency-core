package com.hd.singleton;

/**
 * 懒汉式（线程安全）（不推荐）
 *
 * @author HuaDong
 * @date 2019/11/7 9:34
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
