package com.hd.thread.stop.wrong;

import java.util.concurrent.BlockingQueue;

/**
 * @author HuaDong
 * @date 2019/10/19 22:44
 */
public class Consumer {

    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.95) {
            return false;
        }
        return true;
    }
}