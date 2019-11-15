package com.hd.deadlock.philosopher;

/**
 * 哲学家
 *
 * @author HuaDong
 * @date 2019/11/15 14:34
 */
public class Philosopher implements Runnable {

    private Object leftChopstick;
    private Object rightChopstick;

    public Philosopher(Object leftChopstick, Object rightChopstick) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    /**
     * 每个哲学家重复做的事就是：思考，拿筷子吃面
     */
    @Override
    public void run() {
        try {
            while (true) {
                doAction("思考中...");
                synchronized (leftChopstick) {
                    doAction("拿起左边筷子...");
                    synchronized (rightChopstick) {
                        doAction("拿起右边筷子，然后开始吃面...");
                        // 吧唧吧唧...吃面
                        doAction("放下右边筷子...");
                    }
                    doAction("放下左边筷子...");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((long) (Math.random() * 10));
    }
}