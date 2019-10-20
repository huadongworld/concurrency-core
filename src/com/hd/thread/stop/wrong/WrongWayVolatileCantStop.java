package com.hd.thread.stop.wrong;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 演示用volatile的局限part2 陷入阻塞时，volatile是无法线程的 此例中，生产者的生产速度很快，
 * 消费者消费速度慢，所以阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 *
 * @author HuaDong
 * @date 2019/10/19 22:45
 */
public class WrongWayVolatileCantStop {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take()+"被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了。");

        //一旦消费不需要更多数据了，我们应该让生产者也停下来，但是实际情况
        producer.canceled=true;
        System.out.println(producer.canceled);
    }
}

