package com.hd.thread.commons;

/**
 * 先join再mainThread.getState()
 * 通过debugger看线程join前后状态的对比
 *
 * @author HuaDong
 * @date 2019/11/2 16:46
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(mainThread.getState());
                System.out.println("Thread-0运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        thread.join();
        System.out.println("子线程运行完毕");

    }
}