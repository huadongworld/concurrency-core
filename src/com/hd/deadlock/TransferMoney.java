package com.hd.deadlock;

/**
 * 转账时候遇到死锁，一旦打开注释，便会发生死锁
 *
 * @author HuaDong
 * @date 2019/11/8 11:47
 */
public class TransferMoney implements Runnable {

    private int flag = 1;
    private static Account a = new Account(500);
    private static Account b = new Account(500);
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        //定义两个线程，flag = 1和0分别模拟a和b
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额" + a.balance);
        System.out.println("b的余额" + b.balance);
    }

    @Override
    public void run() {
        if (flag == 1) {
            //a转账给b
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            //b转账给a
            transferMoney(b, a, 200);
        }
    }

    /**
     * 转账方法
     *
     * @param from   转出人
     * @param to     收款人
     * @param amount 转账金额
     */
    public static void transferMoney(Account from, Account to, int amount) {

        /**
         * 辅助类
         */
        class Helper {
            public void transfer() {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败。");
                    return;
                }
                from.balance -= amount;
                to.balance = to.balance + amount;
                System.out.println("成功转账" + amount + "元");
            }
        }

        //使用类的hash值来帮助排序
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);

        if (fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
                    new Helper().transfer();
                }
            }
        } else {
            //发生hash碰撞时，可以增加锁来进行控制，类似“加时赛”
            synchronized (lock) {
                synchronized (to) {
                    synchronized (from) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    /**
     * 收款账户
     */
    static class Account {

        public Account(int balance) {
            this.balance = balance;
        }
        int balance;
    }
}
