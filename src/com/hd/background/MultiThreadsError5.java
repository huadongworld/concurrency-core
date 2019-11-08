package com.hd.background;

/**
 * 观察者模式
 *
 * @author HuaDong
 * @date 2019/11/3 12:32
 */
public class MultiThreadsError5 {

    private int count;

    public MultiThreadsError5(MySource source) {
        source.registerListener(event -> System.out.println("\n我得到的数字是" + count));
        //模拟业务操作
        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySource.eventCome(new Event() {
            });
        }).start();

        new MultiThreadsError5(mySource);
    }

    static class MySource {

        private EventListener listener;

        void registerListener(EventListener eventListener) {
            this.listener = eventListener;
        }

        void eventCome(Event e) {
            if (listener != null) {
                listener.onEvent(e);
            } else {
                System.out.println("还未初始化完毕");
            }
        }

    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {

    }
}
