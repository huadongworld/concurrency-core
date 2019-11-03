package com.hd.thread.background;


/**
 * 用工厂模式修复刚才的初始化问题
 *
 * @author HuaDong
 * @date 2019/11/3 14:28
 */
public class MultiThreadsError7 {

    private int count;
    private EventListener listener;

    private MultiThreadsError7(MySource source) {
        listener = event -> System.out.println("\n我得到的数字是" + count);

        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    public static MultiThreadsError7 getInstance(MySource source) {
        MultiThreadsError7 safeListener = new MultiThreadsError7(source);
        source.registerListener(safeListener.listener);
        return safeListener;
    }

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySource.eventCome(new MultiThreadsError5.Event() {
            });
        }).start();
        new MultiThreadsError7(mySource);
    }

    static class MySource {

        private EventListener listener;

        void registerListener(EventListener eventListener) {
            this.listener = eventListener;
        }

        void eventCome(MultiThreadsError5.Event e) {
            if (listener != null) {
                listener.onEvent(e);
            } else {
                System.out.println("还未初始化完毕");
            }
        }

    }

    interface EventListener {
        void onEvent(MultiThreadsError5.Event e);
    }

    interface Event {
    }
}
