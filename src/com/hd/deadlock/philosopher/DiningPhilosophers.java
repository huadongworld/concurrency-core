package com.hd.deadlock.philosopher;


/**
 * 演示哲学家就餐问题导致的死锁
 *
 * @author HuaDong
 * @date 2019/11/8 11:46
 */
public class DiningPhilosophers {

    public static void main(String[] args) {
        //五个哲学家
        Philosopher[] philosophers = new Philosopher[5];
        //五根筷子
        Object[] chopsticks = new Object[philosophers.length];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[(i + 1) % chopsticks.length];
            philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
            new Thread(philosophers[i], "哲学家" + (i + 1) + "号").start();
        }
    }
}
