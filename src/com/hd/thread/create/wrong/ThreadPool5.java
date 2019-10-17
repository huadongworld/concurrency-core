package com.hd.thread.create.wrong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建线程的方法
 *
 * @author HuaDong
 * @date 2019/10/17 10:14
 */
public class ThreadPool5 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Task() {

            });
        }
    }
}
