package com.hd.thread.singleton;

/**
 * 双重检查（推荐面试使用）
 *
 * @author HuaDong
 * @date 2019/11/7 9:35
 */
public class Singleton6 {

    private volatile static Singleton6 instance;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
