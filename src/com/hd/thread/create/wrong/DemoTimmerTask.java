package com.hd.thread.create.wrong;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器创建线程
 *
 * @author HuaDong
 * @date 2019/10/17 10:10
 */
public class DemoTimmerTask {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
