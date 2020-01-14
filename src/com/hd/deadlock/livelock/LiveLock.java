package com.hd.deadlock.livelock;

/**
 * 演示活锁问题
 *
 * @author HuaDong
 * @date 2019/11/8 11:46
 */
public class LiveLock {

    public static void main(String[] args) {
        Diner husband = new Diner("牛郎");
        Diner wife = new Diner("织女");

        Spoon spoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(spoon, wife)).start();
        new Thread(() -> wife.eatWith(spoon, husband)).start();
    }
}
