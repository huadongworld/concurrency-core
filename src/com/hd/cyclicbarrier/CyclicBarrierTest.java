package com.hd.cyclicbarrier;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * @author HuaDong
 * @date 2020/3/15 14:38
 */
public class CyclicBarrierTest {

    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void demo() {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum,
                () -> System.out.println(Thread.currentThread().getName() + " 完成最后任务"));
        for (int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }
}